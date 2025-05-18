package com.dilon.filemanagerapp.auth.service;

import com.dilon.filemanagerapp.auth.dto.RegisterRequest;
import com.dilon.filemanagerapp.auth.dto.UserResponse;
import com.dilon.filemanagerapp.auth.model.Users;
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
                .accountLocked(false)
                .enabled(false)
                .build();
    }

    public UserResponse fromUser(Users users) {
        if (users == null) {
            return null;
        }
        return new UserResponse(
                users.getId(),
                users.getName(),
                users.getLastName1(),
                users.getLastName2(),
                users.getEmail(),
                users.getCreatedAt().toString(),
                users.getLastModifiedAt().toString(),
                users.getRoles().toString(),
                users.isEnabled(),
                users.isAccountLocked()
        );

    }
}
