package com.dilon.filemanagerapp.general.info.administrative.service;

import com.dilon.filemanagerapp.common.service.BaseDocumentService;
import com.dilon.filemanagerapp.common.service.GeneralInfoMapper;
import com.dilon.filemanagerapp.general.info.administrative.dto.AdministrativeRequest;
import com.dilon.filemanagerapp.general.info.administrative.dto.AdministrativeResponse;
import com.dilon.filemanagerapp.general.info.administrative.model.Administrative;
import com.dilon.filemanagerapp.general.info.administrative.repository.AdministrativeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdministrativeService extends BaseDocumentService<Administrative, AdministrativeRequest, AdministrativeResponse> {

    private final AdministrativeRepository administrativeRepository;

    private final GeneralInfoMapper generalInfoMapper;


    @Override
    protected JpaRepository<Administrative, Integer> getRepository() {
        return administrativeRepository;
    }

    @Override
    protected Administrative mapToEntity(AdministrativeRequest req) {
        return generalInfoMapper.toAdministrative(req);
    }

    @Override
    protected AdministrativeResponse mapToResponse(Administrative entity) {
        return generalInfoMapper.toAdministrativeResponse(entity);
    }

    @Override
    protected JpaSpecificationExecutor<Administrative> getSpecificationExecutor() {
        return administrativeRepository;
    }
}
