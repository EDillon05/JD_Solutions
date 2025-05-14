package com.dilon.filemanagerapp.general.info.experience.dto;


import java.time.LocalDateTime;

public record ExperienceResponse(
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
        String companyName,
        String position,
        String area,
        String contractType
) {
}
