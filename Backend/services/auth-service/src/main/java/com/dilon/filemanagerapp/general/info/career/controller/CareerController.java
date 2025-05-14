package com.dilon.filemanagerapp.general.info.career.controller;

import com.dilon.filemanagerapp.general.info.career.dto.CareerRequest;
import com.dilon.filemanagerapp.general.info.career.dto.CareerResponse;
import com.dilon.filemanagerapp.common.dto.PageResponse;
import com.dilon.filemanagerapp.general.info.career.service.CareerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/careers")
@RequiredArgsConstructor
@Tag(name = "General Info", description = "General Info API")
public class CareerController {

    private final CareerService careerService;


    @PostMapping()
    public ResponseEntity<Integer> saveCareer(@RequestBody @Valid CareerRequest request, Authentication auth) {
        return ResponseEntity.ok(careerService.save(request, auth));
    }

    @GetMapping("/{career-id}")
    public ResponseEntity<CareerResponse> findById(
            @PathVariable("career-id") Integer careerId,
            Authentication auth
    ) {
        return ResponseEntity.ok(careerService.findById(careerId, auth));
    }

    @GetMapping("/owner")
    public ResponseEntity<PageResponse<CareerResponse>> findAllCareersByOwner(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            Authentication auth
    ) {
        return ResponseEntity.ok(careerService.findAllCareersByOwner(page, size, auth));
    }

    @GetMapping("/search")
    public ResponseEntity<PageResponse<CareerResponse>> searchByFilters(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) LocalDateTime startedAt,
            @RequestParam(required = false) LocalDateTime finishedAt,
            Authentication auth
    ) {
        return ResponseEntity.ok(careerService.searchByFilters(page, size, keyword, type, startedAt, finishedAt, auth));
    }


    @PutMapping()
    public ResponseEntity<Integer> updateCareer(
            @RequestBody @Valid CareerRequest request,
            Authentication auth
    ) {
        this.careerService.updateCareer(request, auth);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{career-id}")
    public ResponseEntity<Void> deleteCareer(
            @PathVariable("career-id") String careerId
    ) {
        this.careerService.deleteCareer(careerId);
        return ResponseEntity.accepted().build();
    }

}