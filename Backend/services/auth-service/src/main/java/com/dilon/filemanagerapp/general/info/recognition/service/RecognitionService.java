package com.dilon.filemanagerapp.general.info.recognition.service;

import com.dilon.filemanagerapp.common.file.FileStorageService;
import com.dilon.filemanagerapp.common.service.BaseDocumentService;
import com.dilon.filemanagerapp.common.service.GeneralInfoMapper;
import com.dilon.filemanagerapp.general.info.project.dto.ProjectRequest;
import com.dilon.filemanagerapp.general.info.project.dto.ProjectResponse;
import com.dilon.filemanagerapp.general.info.project.model.Project;
import com.dilon.filemanagerapp.general.info.project.repository.ProjectRepository;
import com.dilon.filemanagerapp.general.info.recognition.dto.RecognitionRequest;
import com.dilon.filemanagerapp.general.info.recognition.dto.RecognitionResponse;
import com.dilon.filemanagerapp.general.info.recognition.model.Recognition;
import com.dilon.filemanagerapp.general.info.recognition.repository.RecognitonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecognitionService extends BaseDocumentService<Recognition, RecognitionRequest, RecognitionResponse> {

    private final GeneralInfoMapper generalInfoMapper;
    private final RecognitonRepository recognitonRepository;

    private final FileStorageService fileStorageService;

    @Override
    protected JpaRepository<Recognition, Integer> getRepository() {
        return recognitonRepository;
    }

    @Override
    protected Recognition mapToEntity(RecognitionRequest req) {
        return generalInfoMapper.toRecognition(req);
    }

    @Override
    protected RecognitionResponse mapToResponse(Recognition entity) {
        return generalInfoMapper.toRecognitionResponse(entity);
    }

    @Override
    protected JpaSpecificationExecutor<Recognition> getSpecificationExecutor() {
        return recognitonRepository;
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
