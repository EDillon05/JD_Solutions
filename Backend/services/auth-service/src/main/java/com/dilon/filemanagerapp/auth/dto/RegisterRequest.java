package com.dilon.filemanagerapp.auth.dto;

import com.dilon.filemanagerapp.common.repository.UpdateRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotNull(message = "name is required")
        @Size(min = 1, message = "name cannot be empty")
        String name,

        @NotNull(message = "Last name at least one is required")
        @Size(min = 1, message = "Last name cannot be empty")
        String lastName1,

        @Size(min = 1, message = "Last name cannot be empty")
        String lastName2,

        @NotNull(message = "email is required")
        @Email(message = "email is not a valid address")
        String email,

        @NotNull(message = "password is required")
        @Size(min = 8, message = "password must be at least 8 characters long")
        @Pattern(regexp = ".*[A-Z].*", message = "password must contain at least one uppercase letter")
        @Pattern(regexp = ".*[0-9].*", message = "password must contain at least one number")
        String password
) implements UpdateRequest {
    @Override
    public Integer getId() {
        return null;
    }
}

