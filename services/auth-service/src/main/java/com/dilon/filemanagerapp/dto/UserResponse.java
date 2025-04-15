package com.dilon.filemanagerapp.dto;

public record UserResponse(
    Integer id,
    String name,
    String lastName1,
    String lastName2,
    String email,
    String phone,
    String createdAt,
    String lastModifiedAt,
    String roles,
    Boolean accountLocked,
    Boolean enabled
) {
}

