package com.dilon.filemanagerapp.profile.dto;

import java.time.LocalDateTime;

public record ProfileResponse(
        String name,
        String firstLastName,
        String secondLastName,
        String email,
        String gender,
        LocalDateTime dateOfBirth,
        String age,
        String phoneNumber,
        String state,
        String city,
        String address,
        String profilePictureUrl,
        String bio
) {
}
