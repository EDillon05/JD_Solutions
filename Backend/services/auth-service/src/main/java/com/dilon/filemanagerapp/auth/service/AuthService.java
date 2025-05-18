package com.dilon.filemanagerapp.auth.service;

import com.dilon.filemanagerapp.auth.dto.AuthenticationRequest;
import com.dilon.filemanagerapp.auth.dto.AuthenticationResponse;
import com.dilon.filemanagerapp.auth.dto.RegisterRequest;
import com.dilon.filemanagerapp.auth.dto.UserResponse;
import com.dilon.filemanagerapp.email.EmailService;
import com.dilon.filemanagerapp.email.EmailTemplateName;
import com.dilon.filemanagerapp.auth.model.Users;
import com.dilon.filemanagerapp.auth.repository.RoleRepository;
import com.dilon.filemanagerapp.auth.repository.TokenRepository;
import com.dilon.filemanagerapp.auth.repository.UserRepository;
import com.dilon.filemanagerapp.auth.security.JwtService;
import com.dilon.filemanagerapp.auth.security.Token;

import com.dilon.filemanagerapp.profile.model.Profile;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final RoleRepository roleRepository;
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper mapper;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final EmailService emailService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Value("${application.mailing.frontend.activation-url}")
    private String activationUrl;


    public void registerUser(RegisterRequest request) throws MessagingException {
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new RuntimeException("User already exists");
        }
        var userRole = roleRepository.findByName("USER")
                .orElseThrow(() -> new RuntimeException("Role not found: USER"));

        var user = mapper.toUser(request);

        user.setPassword(passwordEncoder.encode(request.password()));

        user.setRoles(Set.of(userRole));

        Profile profile = new Profile();
        profile.setUser(user); // Importante
        user.setProfile(profile); // Importante

        userRepository.save(user); // Cascade guarda el perfil también

        sendValidationEmail(user);

    }

    private void sendValidationEmail(Users users) throws MessagingException {
        var newToken = generateAndSaveActivationToken(users);
        // send email

        emailService.sendEmail(
                users.getEmail(),
                users.fullName(),
                EmailTemplateName.ACTIVATE_ACCOUNT,
                activationUrl,
                newToken,
                "Account Activation"
        );
    }

    private String generateAndSaveActivationToken(Users users) {
        String generatedToken = generateActivationCode(6);
        var token = Token.builder()
                .token(generatedToken)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(15))
                .users(users)
                .build();

        tokenRepository.save(token);
        return generatedToken;
    }

    private String generateActivationCode(int length) {
        String character = "0123456789";
        StringBuilder codeBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(character.length());
            codeBuilder.append(character.charAt(randomIndex));
        }

        return codeBuilder.toString();
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        var claims = new HashMap<String, Object>();
        var user = ((Users) auth.getPrincipal());
        claims.put("fullName", user.fullName());
        var jwtToken = jwtService.generateToken(claims, user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public List<UserResponse> findAllCustomers() {
        return repository.findAll()
                .stream()
                .map(this.mapper::fromUser)
                .collect(Collectors.toList());
    }

    public UserResponse findById(Integer id) {
        return repository.findById(id)
                .map(this.mapper::fromUser)
                .orElseThrow(() -> new RuntimeException("Users not found: " + id));
    }

    //@Transactional
    public void activateAccount(String token) throws MessagingException {
        Token savedToken = tokenRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid token"));
        if (LocalDateTime.now().isAfter(savedToken.getExpiresAt())) {
            sendValidationEmail(savedToken.getUsers());
            throw new RuntimeException("Token expired. A new token has been sent to the same email address.");
        }
        var user = userRepository.findById(savedToken.getUsers().getId())
                .orElseThrow(() -> new UsernameNotFoundException("Users not found"));
        user.setEnabled(true);
        userRepository.save(user);
        savedToken.setValidatedAt(LocalDateTime.now());
        tokenRepository.save(savedToken);
    }
}


