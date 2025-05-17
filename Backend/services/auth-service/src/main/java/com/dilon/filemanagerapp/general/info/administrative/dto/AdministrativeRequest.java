package com.dilon.filemanagerapp.general.info.administrative.dto;

import com.dilon.filemanagerapp.common.repository.UpdateRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Valid
public record AdministrativeRequest(
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

        @NotNull(message = "507")
        @NotEmpty(message = "507")
        String position,
        @NotNull(message = "508")
        @NotEmpty(message = "508")
        String academicUnit,
        @NotNull(message = "509")
        @NotEmpty(message = "509")
        String institution,
        @NotNull(message = "510")
        @NotEmpty(message = "510")
        String level,
        @NotNull(message = "511")
        @NotEmpty(message = "511")
        String modality
) implements UpdateRequest {
    @Override
    public Integer getId() {
        return id;
    }
}
