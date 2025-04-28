package com.dilon.filemanagerapp.auth.controller;

import com.dilon.filemanagerapp.auth.dto.AuthenticationRequest;
import com.dilon.filemanagerapp.auth.dto.AuthenticationResponse;
import com.dilon.filemanagerapp.auth.dto.RegisterRequest;
import com.dilon.filemanagerapp.auth.dto.UserResponse;
import com.dilon.filemanagerapp.auth.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Tag(name = "Authentication")
    public ResponseEntity<?> registerUser(
            @RequestBody @Valid RegisterRequest request
    ) throws MessagingException {
        service.registerUser(request);
        return ResponseEntity.accepted().build();
    }


    @PostMapping("/authenticate")
    @Tag(name = "Authentication")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody @Valid AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/activate-account")
    @Tag(name = "Authentication")
    public void confirm(
            @RequestParam String token
    ) throws MessagingException {
        service.activateAccount(token);
    }

    @GetMapping
    @Tag(name = "Authentication")
    public ResponseEntity<List<UserResponse>> findAll() {
    return ResponseEntity.ok(this.service.findAllCustomers());
    }

    @GetMapping("/{user-id}")
    @Tag(name = "Authentication")
    public ResponseEntity<UserResponse> findById(@PathVariable ("user-id")Integer userId) {
        return ResponseEntity.ok(service.findById(userId));
    }

}
