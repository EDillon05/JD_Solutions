package com.dilon.filemanagerapp.profile.service;

import com.dilon.filemanagerapp.auth.model.Users;
import com.dilon.filemanagerapp.profile.dto.ProfileRequest;
import com.dilon.filemanagerapp.profile.dto.ProfileResponse;
import com.dilon.filemanagerapp.profile.model.Profile;
import com.dilon.filemanagerapp.profile.repository.ProfileRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileMapper mapper;

    private final ProfileRepository profileRepository;

    public void update(@Valid ProfileRequest request, Authentication auth) {
        Users users = (Users) auth.getPrincipal();
        Profile profile = users.getProfile();
        var userProfile = profileRepository.findById(profile.getId()).orElseThrow(() -> new RuntimeException("Users not found: " + profile.getId()));
        mergeProfile(request, userProfile);
        this.profileRepository.save(userProfile);
    }

    private void mergeProfile(@Valid ProfileRequest request, Profile profile) {
        if (StringUtils.isNotBlank(request.gender())) {
            profile.setGender(request.gender());
        }
        if (request.dateOfBirth() != null) {
            profile.setDateOfBirth(request.dateOfBirth());
        }
        if (StringUtils.isNotBlank(request.age())) {
            profile.setAge(request.age());
        }
        if (StringUtils.isNotBlank(request.phoneNumber())) {
            profile.setPhoneNumber(request.phoneNumber());
        }
        if (StringUtils.isNotBlank(request.state())) {
            profile.setState(request.state());
        }
        if (StringUtils.isNotBlank(request.city())) {
            profile.setCity(request.city());
        }
        if (StringUtils.isNotBlank(request.address())) {
            profile.setAddress(request.address());
        }
        if (StringUtils.isNotBlank(request.profilePictureUrl())) {
            profile.setProfilePictureUrl(request.profilePictureUrl());
        }
        if (StringUtils.isNotBlank(request.bio())) {
            profile.setBio(request.bio());
        }
    }

    public ProfileResponse getProfile(Authentication auth) {
        Users users = (Users) auth.getPrincipal();
        Profile profile = users.getProfile();
        return profileRepository.findById(profile.getId()).map(mapper::fromProfile).orElseThrow(() -> new RuntimeException("Users not found: " + profile.getId()));

    }
}
