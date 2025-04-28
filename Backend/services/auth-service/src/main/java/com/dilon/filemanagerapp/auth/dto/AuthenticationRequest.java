package com.dilon.filemanagerapp.auth.dto;

import jakarta.validation.constraints.*;


public record AuthenticationRequest(
        @NotEmpty(message = "email is required")
        @NotBlank(message = "email is required")
        @Email(message = "email is not a valid address")
        String email,

        @NotNull(message = "password is required")
        @Size(min = 8, message = "password must be at least 8 characters long")
        @Pattern(regexp = ".*[A-Z].*", message = "password must contain at least one uppercase letter")
        @Pattern(regexp = ".*[0-9].*", message = "password must contain at least one number")
        String password
) {
}
