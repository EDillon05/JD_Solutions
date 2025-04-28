package com.dilon.filemanagerapp.auth.service;

import com.dilon.filemanagerapp.auth.dto.RegisterRequest;
import com.dilon.filemanagerapp.auth.dto.UserResponse;
import com.dilon.filemanagerapp.auth.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toUser(RegisterRequest request) {
        if (request == null) {
            return null;
        }
        return User.builder()
                .name(request.name())
                .lastName1(request.lastName1())
                .lastName2(request.lastName2())
                .email(request.email())
                .password(request.password())
                .accountLocked(false)
                .enabled(false)
                .build();
    }

    public UserResponse fromUser(User user) {
        if (user == null) {
            return null;
        }
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getLastName1(),
                user.getLastName2(),
                user.getEmail(),
                user.getCreatedAt().toString(),
                user.getLastModifiedAt().toString(),
                user.getRoles().toString(),
                user.isEnabled(),
                user.isAccountLocked()
        );

    }
}
