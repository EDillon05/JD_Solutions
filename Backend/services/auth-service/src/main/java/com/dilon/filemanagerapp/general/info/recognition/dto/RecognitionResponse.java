package com.dilon.filemanagerapp.general.info.recognition.dto;

import java.time.LocalDateTime;

public record RecognitionResponse(
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
        String institutionGiven,
        String reason,
        String level,
        String typeOfRecognition
) {
}
