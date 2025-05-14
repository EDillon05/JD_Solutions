package com.dilon.filemanagerapp.general.info.career.dto;

import java.time.LocalDateTime;

public record CareerResponse(
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
        String level,
        String institution,
        String certification_name,
        String licenseId,
        String modality,
        LocalDateTime graduation_date
) {
}
