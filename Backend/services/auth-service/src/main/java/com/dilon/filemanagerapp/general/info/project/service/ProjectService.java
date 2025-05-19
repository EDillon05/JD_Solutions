package com.dilon.filemanagerapp.general.info.project.service;

import com.dilon.filemanagerapp.common.file.FileStorageService;
import com.dilon.filemanagerapp.common.service.BaseDocumentService;
import com.dilon.filemanagerapp.common.service.GeneralInfoMapper;
import com.dilon.filemanagerapp.general.info.project.dto.ProjectRequest;
import com.dilon.filemanagerapp.general.info.project.dto.ProjectResponse;
import com.dilon.filemanagerapp.general.info.project.model.Project;
import com.dilon.filemanagerapp.general.info.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService extends BaseDocumentService<Project, ProjectRequest, ProjectResponse> {

    private final ProjectRepository projectRepository;

    private final GeneralInfoMapper generalInfoMapper;

    private final FileStorageService fileStorageService;


    @Override
    protected JpaRepository<Project, Integer> getRepository() {
        return projectRepository;
    }

    @Override
    protected Project mapToEntity(ProjectRequest req) {
        return generalInfoMapper.toProject(req);
    }

    @Override
    protected ProjectResponse mapToResponse(Project entity) {
        return generalInfoMapper.toProjectResponse(entity);
    }

    @Override
    protected JpaSpecificationExecutor<Project> getSpecificationExecutor() {
        return projectRepository;
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
