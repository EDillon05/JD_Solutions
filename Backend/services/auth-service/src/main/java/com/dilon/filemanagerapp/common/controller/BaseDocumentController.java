package com.dilon.filemanagerapp.common.controller;

import com.dilon.filemanagerapp.common.dto.PageResponse;
import com.dilon.filemanagerapp.common.repository.UpdateRequest;
import com.dilon.filemanagerapp.common.service.BaseDocumentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public abstract class BaseDocumentController<Req extends UpdateRequest, Res, Service extends BaseDocumentService<?, Req, Res>> {

    protected final Service service;

    @PostMapping
    public ResponseEntity<Integer> save(@RequestBody @Valid Req request, Authentication auth) {
        return ResponseEntity.ok(service.save(request, auth));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Res> findById(@PathVariable("id") Integer id, Authentication auth) {
        return ResponseEntity.ok(service.findById(id, auth));
    }

    @GetMapping("/owner")
    public ResponseEntity<PageResponse<Res>> findAllByOwner(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Authentication auth) {
        return ResponseEntity.ok(service.findAllByOwner(page, size, auth));
    }

    @GetMapping("/search")
    public ResponseEntity<PageResponse<Res>> searchByFilters(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) LocalDateTime startedAt,
            @RequestParam(required = false) LocalDateTime finishedAt,
            Authentication auth
    ) {
        return ResponseEntity.ok(service.searchByFilters(page, size, keyword, type, startedAt, finishedAt, auth));
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid Req request, Authentication auth) {
        service.update(request, auth);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id, Authentication auth) {
        service.deleteById(id, auth);
        return ResponseEntity.accepted().build();
    }
}

