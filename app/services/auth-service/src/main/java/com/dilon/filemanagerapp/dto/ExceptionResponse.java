package com.dilon.filemanagerapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.Map;
import java.util.Set;

@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record ExceptionResponse(
        Integer businessErrorCode,
        String businessExceptionDescription,
        String error,
        Set<String> validationErrors,
        Map<String, String> errors

) {
}
