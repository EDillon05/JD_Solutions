package com.dilon.filemanagerapp.auth.dto;

public record UserResponse(
    Integer id,
    String name,
    String lastName1,
    String lastName2,
    String email,
    String createdAt,
    String lastModifiedAt,
    String roles,
    Boolean accountLocked,
    Boolean enabled
) {
}

