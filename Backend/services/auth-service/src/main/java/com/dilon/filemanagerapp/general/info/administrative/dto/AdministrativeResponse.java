package com.dilon.filemanagerapp.general.info.administrative.dto;

import java.time.LocalDateTime;

public record AdministrativeResponse(
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
        String position,
        String academicUnit,
        String institution,
        String level,
        String modality
) {
}
