package com.dilon.filemanagerapp.general.info.experience.controller;

import com.dilon.filemanagerapp.common.dto.PageResponse;
import com.dilon.filemanagerapp.general.info.experience.dto.ExperienceRequest;
import com.dilon.filemanagerapp.general.info.experience.dto.ExperienceResponse;
import com.dilon.filemanagerapp.general.info.experience.service.ExperienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/experiences")
@RequiredArgsConstructor
public class ExperienceController {

    private final ExperienceService experienceService;

    @PostMapping()
    public ResponseEntity<Integer> save(@RequestBody @Valid ExperienceRequest request, Authentication auth) {
        return ResponseEntity.ok(experienceService.save(request, auth));
    }

    @PutMapping()
    public ResponseEntity<Integer> update(
            @RequestBody @Valid ExperienceRequest request,
            Authentication auth
    ) {
        this.experienceService.update(request, auth);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{experience-id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable("experience-id") String careerId,
            Authentication auth
    ) {
        this.experienceService.deleteById(Integer.valueOf(careerId), auth);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/owner")
    public ResponseEntity<PageResponse<ExperienceResponse>> findAllByOwner(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            Authentication auth
    ) {
        return ResponseEntity.ok(experienceService.findAllByOwner(page, size, auth));
    }

    @GetMapping("/{experience-id}")
    public ResponseEntity<ExperienceResponse> findById(
            @PathVariable("experience-id") Integer careerId,
            Authentication auth
    ) {
        return ResponseEntity.ok(experienceService.findById(careerId, auth));
    }

    @GetMapping("/search")
    public ResponseEntity<PageResponse<ExperienceResponse>> searchByFilters(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) LocalDateTime startedAt,
            @RequestParam(required = false) LocalDateTime finishedAt,
            Authentication auth
    ) {
        return ResponseEntity.ok(experienceService.searchByFilters(page, size, keyword, type, startedAt, finishedAt, auth));
    }
}
