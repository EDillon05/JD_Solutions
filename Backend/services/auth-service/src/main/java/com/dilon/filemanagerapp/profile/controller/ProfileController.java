package com.dilon.filemanagerapp.profile.controller;

import com.dilon.filemanagerapp.profile.dto.ProfileRequest;
import com.dilon.filemanagerapp.profile.dto.ProfileResponse;
import com.dilon.filemanagerapp.profile.model.Profile;
import com.dilon.filemanagerapp.profile.service.ProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
@Tag(name = "general-info", description = "General Info API")
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping
    public ResponseEntity<ProfileResponse> getProfile(Authentication auth) {
        return ResponseEntity.ok(profileService.getProfile(auth));
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid ProfileRequest request, Authentication auth) {
        profileService.update(request, auth);
        return ResponseEntity.accepted().build();
    }

}
