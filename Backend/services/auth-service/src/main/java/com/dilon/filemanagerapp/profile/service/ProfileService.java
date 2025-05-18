package com.dilon.filemanagerapp.profile.service;

import com.dilon.filemanagerapp.profile.dto.ProfileRequest;
import com.dilon.filemanagerapp.profile.model.Profile;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    public Profile save(@Valid ProfileRequest request, Authentication auth) {
        return null;
    }
}
