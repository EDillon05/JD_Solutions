package com.dilon.filemanagerapp.general.info.experience.service;



import com.dilon.filemanagerapp.common.file.FileStorageService;
import com.dilon.filemanagerapp.common.service.BaseDocumentService;
import com.dilon.filemanagerapp.general.info.experience.dto.ExperienceRequest;
import com.dilon.filemanagerapp.general.info.experience.dto.ExperienceResponse;
import com.dilon.filemanagerapp.general.info.experience.model.Experience;
import com.dilon.filemanagerapp.general.info.experience.repository.ExperienceRepository;
import com.dilon.filemanagerapp.common.service.GeneralInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ExperienceService extends BaseDocumentService<Experience, ExperienceRequest, ExperienceResponse> {

    private final ExperienceRepository experienceRepository;

    private final GeneralInfoMapper generalInfoMapper;

    private final FileStorageService fileStorageService;

    @Override
    protected JpaRepository<Experience, Integer> getRepository() {
        return experienceRepository;
    }

    @Override
    protected Experience mapToEntity(ExperienceRequest req) {
        return generalInfoMapper.toExperience(req);
    }

    @Override
    protected ExperienceResponse mapToResponse(Experience entity) {
        return generalInfoMapper.toExperienceResponse(entity);
    }

    @Override
    protected JpaSpecificationExecutor<Experience> getSpecificationExecutor() {
        return experienceRepository;
    }

    @Override
    protected String getEntityFolderName() {
        return "administrative";
    }

    @Override
    protected FileStorageService getFileStorageService() {
        return fileStorageService;
    }
}

