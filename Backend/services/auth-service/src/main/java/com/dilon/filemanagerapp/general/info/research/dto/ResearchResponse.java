package com.dilon.filemanagerapp.general.info.research.dto;

import java.time.LocalDateTime;

public record ResearchResponse(
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
        String publicationType, //e.g. book, article, etc.
        String publicationTitle,
        String magazineName, //if applicable
        LocalDateTime publicationDate, //if applicable
        String doi, //Digital Object Identifier
        String isbn,
        String eventName //if applicable
) {
}
