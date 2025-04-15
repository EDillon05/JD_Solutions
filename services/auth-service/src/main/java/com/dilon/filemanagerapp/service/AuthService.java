package com.dilon.filemanagerapp.service;

import com.dilon.filemanagerapp.dto.RegisterRequest;
import com.dilon.filemanagerapp.dto.UserResponse;
import com.dilon.filemanagerapp.email.EmailService;
import com.dilon.filemanagerapp.email.EmailTemplateName;
import com.dilon.filemanagerapp.model.User;
import com.dilon.filemanagerapp.repository.RoleRepository;
import com.dilon.filemanagerapp.repository.TokenRepository;
import com.dilon.filemanagerapp.repository.UserRepository;
import com.dilon.filemanagerapp.security.Token;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
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

    @Value("${application.mailing.frontend.activation-url}")
    private String activationUrl;


    public void registerUser(RegisterRequest request) throws MessagingException {
        var userRole = roleRepository.findByName("USER")
                .orElseThrow(() -> new RuntimeException("Role not found: USER"));

        var user = mapper.toUser(request);

        user.setPassword(passwordEncoder.encode(request.password()));

        user.setRoles(Set.of(userRole));

        userRepository.save(user);

        sendValidationEmail(user);

//        var user = User.builder()
//                .name(request.name())
//                .lastName1(request.lastName1())
//                .lastName2(request.lastName2())
//                .email(request.email())
//                .password(passwordEncoder.encode(request.password()))
//                .accountLocked(false)
//                .enabled(false)
//                .roles(Set.of(userRole))
//                .build()
//                ;
//
//        userRepository.save(user);

//        // 👇 Cargar los roles por ID para que no estén detached
//        Set<Roles> managedRoles = request.roles().stream()
//                .map(role -> roleRepository.findById(role.getId())
//                        .orElseThrow(() -> new RuntimeException("Role not found: " + role.getId())))
//                .collect(Collectors.toSet());
//
//        user.setRoles(managedRoles);
//
//        var saved = repository.save(user);
//        return saved.getId();
    }

    private void sendValidationEmail(User user) throws MessagingException {
        var newToken = generateAndSaveActivationToken(user);
        // send email

        emailService.sendEmail(
                user.getEmail(),
                user.fullName(),
                EmailTemplateName.ACTIVATE_ACCOUNT,
                activationUrl,
                newToken,
                "Account Activation"
        );
    }

    private String generateAndSaveActivationToken(User user) {
        String generatedToken = generateActivationCode(6);
        var token = Token.builder()
                .token(generatedToken)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(15))
                .user(user)
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

    public List<UserResponse> findAllCustomers() {
        return repository.findAll()
                .stream()
                .map(this.mapper::fromUser)
                .collect(Collectors.toList());
    }

    public UserResponse findById(Integer id) {
        return repository.findById(id)
                .map(this.mapper::fromUser)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
    }
}

