package com.dilon.filemanagerapp.profile.service;

import com.dilon.filemanagerapp.common.file.FileUtils;
import com.dilon.filemanagerapp.profile.dto.ProfileResponse;
import com.dilon.filemanagerapp.profile.model.Profile;
import org.springframework.stereotype.Component;


@Component
public class ProfileMapper {
    public ProfileResponse fromProfile(Profile profile) {
        if (profile == null) {
            return null;
        }
        return new ProfileResponse(
                profile.getUser().getName(),
                profile.getUser().getLastName1(),
                profile.getUser().getLastName2(),
                profile.getUser().getEmail(),
                profile.getGender(),
                profile.getDateOfBirth(),
                profile.getAge(),
                profile.getPhoneNumber(),
                profile.getState(),
                profile.getCity(),
                profile.getAddress(),
                profile.getProfilePictureUrl(),
                profile.getBio()
        );
    }
}