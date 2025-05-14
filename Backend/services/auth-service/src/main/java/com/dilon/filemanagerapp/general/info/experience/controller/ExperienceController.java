package com.dilon.filemanagerapp.general.info.experience.controller;

import com.dilon.filemanagerapp.general.info.experience.dto.ExperienceRequest;
import com.dilon.filemanagerapp.general.info.experience.dto.ExperienceResponse;
import com.dilon.filemanagerapp.general.info.experience.service.ExperienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiences")
@RequiredArgsConstructor
public class ExperienceController {

    private final ExperienceService experienceService;

    @PostMapping()
    public ResponseEntity<Integer> saveExperience(@RequestBody @Valid ExperienceRequest request, Authentication auth) {
        return ResponseEntity.ok(experienceService.save(request, auth));
    }

    @GetMapping()
    public ResponseEntity<List<ExperienceResponse>> getAll(Authentication auth) {
        return ResponseEntity.ok(experienceService.findAll(auth));
    }
}
