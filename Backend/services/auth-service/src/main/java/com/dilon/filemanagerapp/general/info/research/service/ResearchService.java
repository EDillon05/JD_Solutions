package com.dilon.filemanagerapp.general.info.research.service;

import com.dilon.filemanagerapp.common.service.BaseDocumentService;
import com.dilon.filemanagerapp.common.service.GeneralInfoMapper;
import com.dilon.filemanagerapp.general.info.research.dto.ResearchRequest;
import com.dilon.filemanagerapp.general.info.research.dto.ResearchResponse;
import com.dilon.filemanagerapp.general.info.research.model.Research;
import com.dilon.filemanagerapp.general.info.research.repository.ResearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResearchService extends BaseDocumentService<Research, ResearchRequest, ResearchResponse> {

    private final ResearchRepository researchRepository;

    private final GeneralInfoMapper generalInfoMapper;


    @Override
    protected JpaRepository<Research, Integer> getRepository() {
        return researchRepository;
    }

    @Override
    protected Research mapToEntity(ResearchRequest req) {
        return generalInfoMapper.toResearch(req);
    }

    @Override
    protected ResearchResponse mapToResponse(Research entity) {
        return generalInfoMapper.toResearchResponse(entity);
    }

    @Override
    protected JpaSpecificationExecutor<Research> getSpecificationExecutor() {
        return researchRepository;
    }
}
