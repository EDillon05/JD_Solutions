package com.dilon.filemanagerapp.profile.dto;


import com.dilon.filemanagerapp.auth.model.Users;

public record ProfileRequest(
        String profilePictureUrl,
        String bio,
        Users users
) {
}
