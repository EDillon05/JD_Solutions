package com.dilon.filemanagerapp.general.info.teaching.dto;

import com.dilon.filemanagerapp.common.repository.UpdateRequest;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TeachingRequest(
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
        String assessmentName,
        @NotNull(message = "108")
        @NotEmpty(message = "108")
        String programName,
        @NotNull(message = "109")
        @NotEmpty(message = "109")
        String level,
        @NotNull(message = "110")
        @NotEmpty(message = "110")
        String institution,
        @NotNull(message = "111")
        @NotEmpty(message = "111")
        String modality,
        @NotNull(message = "112")
        @NotEmpty(message = "112")
        String weeklyHours

) implements UpdateRequest {
    @Override
    public Integer getId() {
        return id;
    }
}
