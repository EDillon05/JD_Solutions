package com.dilon.filemanagerapp.controller;

import com.dilon.filemanagerapp.dto.RegisterRequest;
import com.dilon.filemanagerapp.dto.UserResponse;
import com.dilon.filemanagerapp.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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



    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
    return ResponseEntity.ok(this.service.findAllCustomers());
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<UserResponse> findById(@PathVariable ("user-id")Integer userId) {
        return ResponseEntity.ok(service.findById(userId));
    }

}
