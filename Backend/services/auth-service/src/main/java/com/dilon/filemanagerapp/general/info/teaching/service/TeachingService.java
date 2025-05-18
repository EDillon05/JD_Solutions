package com.dilon.filemanagerapp.general.info.teaching.service;

import com.dilon.filemanagerapp.common.service.BaseDocumentService;
import com.dilon.filemanagerapp.common.service.GeneralInfoMapper;
import com.dilon.filemanagerapp.general.info.teaching.dto.TeachingRequest;
import com.dilon.filemanagerapp.general.info.teaching.dto.TeachingResponse;
import com.dilon.filemanagerapp.general.info.teaching.model.Teaching;
import com.dilon.filemanagerapp.general.info.teaching.repository.TeachingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeachingService extends BaseDocumentService<Teaching, TeachingRequest, TeachingResponse> {
    private final TeachingRepository teachingRepository;

    private final GeneralInfoMapper generalInfoMapper;


    @Override
    protected JpaRepository<Teaching, Integer> getRepository() {
        return teachingRepository;
    }

    @Override
    protected Teaching mapToEntity(TeachingRequest req) {
        return generalInfoMapper.toTeaching(req);
    }

    @Override
    protected TeachingResponse mapToResponse(Teaching entity) {
        return generalInfoMapper.toTeachingResponse(entity);
    }

    @Override
    protected JpaSpecificationExecutor<Teaching> getSpecificationExecutor() {
        return teachingRepository;
    }
}
