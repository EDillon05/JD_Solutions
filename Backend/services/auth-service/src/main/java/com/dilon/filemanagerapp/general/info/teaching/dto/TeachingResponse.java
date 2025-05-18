package com.dilon.filemanagerapp.general.info.teaching.dto;

import java.time.LocalDateTime;

public record TeachingResponse(
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
        String assessmentName,
        String programName,
        String level,
        String institution,
        String modality,
        String weeklyHours
) {

}
