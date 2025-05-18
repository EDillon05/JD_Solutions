package com.dilon.filemanagerapp.profile.controller;

import com.dilon.filemanagerapp.profile.dto.ProfileRequest;
import com.dilon.filemanagerapp.profile.model.Profile;
import com.dilon.filemanagerapp.profile.service.ProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
@Tag(name = "General Info", description = "General Info API")
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/create")
    ResponseEntity<Profile> saveProfile(
            @RequestBody
            @Valid
            ProfileRequest request, Authentication auth
    ) {
        return ResponseEntity.ok(profileService.save(request, auth));
    }

}
