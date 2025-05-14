package com.dilon.filemanagerapp.general.info.experience.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ExperienceRequest(
        Integer id,
        @NotNull(message = "100")
        @NotEmpty(message = "100")
        String name,
        @NotNull(message = "101")
        @NotEmpty(message = "101")
        String type,
        @NotNull(message = "102")
        @NotEmpty(message = "102")
        String description,
        @NotNull(message = "103")
        @NotEmpty(message = "103")
        String country,
        @NotNull(message = "104")
        LocalDateTime startedAt,
        @NotNull(message = "105")
        LocalDateTime finishedAt,
        String comment,
        String url,
        @NotNull(message = "106")
        @NotEmpty(message = "106")
        String status,

        @NotNull(message = "107")
        @NotEmpty(message = "107")
        String companyName,
        @NotNull(message = "108")
        @NotEmpty(message = "108")
        String position,
        @NotNull(message = "109")
        @NotEmpty(message = "109")
        String area,
        @NotNull(message = "110")
        @NotEmpty(message = "110")
        String contractType
        ) {
}
