package com.dilon.filemanagerapp.service;

import com.dilon.filemanagerapp.dto.RegisterRequest;
import com.dilon.filemanagerapp.model.Users;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public Users toUser(RegisterRequest request) {
        if (request == null) {
            return null;
        }
        return Users.builder()
                .name(request.name())
                .lastName1(request.lastName1())
                .lastName2(request.lastName2())
                .email(request.email())
                .password(request.password())
                .phone(request.phone())
                .createdAt(request.createdAt())
                .roles(request.roles())
                .build();
    }
}
