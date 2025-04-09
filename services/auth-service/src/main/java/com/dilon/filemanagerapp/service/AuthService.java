package com.dilon.filemanagerapp.service;

import com.dilon.filemanagerapp.dto.RegisterRequest;
import com.dilon.filemanagerapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;

    private final UserMapper mapper;

    public Integer registerUser(RegisterRequest request) {
        var user = repository.save(mapper.toUser(request));
        return user.getId();
    }
}

