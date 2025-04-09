package com.dilon.filemanagerapp.controller;

import com.dilon.filemanagerapp.dto.RegisterRequest;
import com.dilon.filemanagerapp.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
