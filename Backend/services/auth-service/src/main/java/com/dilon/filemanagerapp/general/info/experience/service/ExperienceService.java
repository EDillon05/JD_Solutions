package com.dilon.filemanagerapp.general.info.experience.service;


import com.dilon.filemanagerapp.auth.model.User;
import com.dilon.filemanagerapp.common.service.BaseDocumentService;
import com.dilon.filemanagerapp.general.info.experience.dto.ExperienceRequest;
import com.dilon.filemanagerapp.general.info.experience.dto.ExperienceResponse;
import com.dilon.filemanagerapp.general.info.experience.model.Experience;
import com.dilon.filemanagerapp.general.info.experience.repository.ExperienceRepository;
import com.dilon.filemanagerapp.common.service.GeneralInfoMapper;
import com.dilon.filemanagerapp.profile.model.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExperienceService extends BaseDocumentService<Experience, ExperienceRequest> {

    private final ExperienceRepository experienceRepository;
    private final GeneralInfoMapper generalInfoMapper;



    public List<ExperienceResponse> findAll(Authentication auth) {
        User user = (User) auth.getPrincipal();
        Profile profile = user.getProfile();

        return experienceRepository.findAllByOwner(profile)
                .stream()
                .map(generalInfoMapper::toExperienceResponse)
                .collect(Collectors.toList());
    }

    @Override
    protected JpaRepository<Experience, Integer> getRepository() {
        return experienceRepository;
    }

    @Override
    protected Experience mapToEntity(ExperienceRequest dto) {
        return generalInfoMapper.toExperience(dto);
    }
}

