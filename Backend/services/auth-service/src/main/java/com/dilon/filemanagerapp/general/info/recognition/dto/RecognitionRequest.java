package com.dilon.filemanagerapp.general.info.recognition.dto;

import com.dilon.filemanagerapp.common.repository.UpdateRequest;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RecognitionRequest(
        Integer id,
        @NotNull(message = "500")
        @NotEmpty(message = "500")
        String name,
        @NotNull(message = "501")
        @NotEmpty(message = "501")
        String type,
        String description,
        @NotNull(message = "503")
        @NotEmpty(message = "503")
        String country,
        @NotNull(message = "504")
        LocalDateTime startedAt,
        @NotNull(message = "505")
        LocalDateTime finishedAt,
        String comment,
        String url,
        @NotNull(message = "506")
        @NotEmpty(message = "506")
        String status,
        String institutionGiven,
        String reason,
        String level,
        String typeOfRecognition
) implements UpdateRequest {
    @Override
    public Integer getId() {
        return id;
    }
}
