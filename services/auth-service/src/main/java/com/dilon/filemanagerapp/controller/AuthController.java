package com.dilon.filemanagerapp.controller;

import com.dilon.filemanagerapp.dto.RegisterRequest;
import com.dilon.filemanagerapp.dto.UserResponse;
import com.dilon.filemanagerapp.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping
    public ResponseEntity<Integer> registerUser(
            @RequestBody @Valid RegisterRequest request
    ){
        return ResponseEntity.ok(service.registerUser(request));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
    return ResponseEntity.ok(this.service.findAllCustomers());
    }

}
