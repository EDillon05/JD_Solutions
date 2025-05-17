package com.dilon.filemanagerapp.general.info.teaching.controller;

import com.dilon.filemanagerapp.common.dto.PageResponse;
import com.dilon.filemanagerapp.general.info.teaching.dto.TeachingRequest;
import com.dilon.filemanagerapp.general.info.teaching.dto.TeachingResponse;
import com.dilon.filemanagerapp.general.info.teaching.service.TeachingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/teachings")
@RequiredArgsConstructor
public class TeachingController {


    private final TeachingService teachingService;

    @PostMapping()
    public ResponseEntity<Integer> save(@RequestBody @Valid TeachingRequest request, Authentication auth) {
        return ResponseEntity.ok(teachingService.save(request, auth));
    }

    @PutMapping()
    public ResponseEntity<Integer> update(
            @RequestBody @Valid TeachingRequest request,
            Authentication auth
    ) {
        this.teachingService.update(request, auth);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{teaching-id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable("teaching-id") String teachingId,
            Authentication auth
    ) {
        this.teachingService.deleteById(Integer.valueOf(teachingId), auth);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/owner")
    public ResponseEntity<PageResponse<TeachingResponse>> findAllByOwner(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            Authentication auth
    ) {
        return ResponseEntity.ok(teachingService.findAllByOwner(page, size, auth));
    }

    @GetMapping("/{teaching-id}")
    public ResponseEntity<TeachingResponse> findById(
            @PathVariable("teaching-id") Integer teachingId,
            Authentication auth
    ) {
        return ResponseEntity.ok(teachingService.findById(teachingId, auth));
    }

    @GetMapping("/search")
    public ResponseEntity<PageResponse<TeachingResponse>> searchByFilters(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) LocalDateTime startedAt,
            @RequestParam(required = false) LocalDateTime finishedAt,
            Authentication auth
    ) {
        return ResponseEntity.ok(teachingService.searchByFilters(page, size, keyword, type, startedAt, finishedAt, auth));
    }
}
