package com.dilon.filemanagerapp.general.info.project.dto;

import java.time.LocalDateTime;

public record ProjectResponse(
        Integer id,
        String name,
        String type,
        String description,
        String country,
        LocalDateTime startedAt,
        LocalDateTime finishedAt,
        String comment,
        String url,
        String status,
        String role,
        String institutionName,
        String budget,
        String projectLink,
        LocalDateTime publicationDate,
        String disciplinaryArea
) {
}
