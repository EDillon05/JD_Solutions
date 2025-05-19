package com.dilon.filemanagerapp.general.info.career.service;

import com.dilon.filemanagerapp.common.service.BaseDocumentService;
import com.dilon.filemanagerapp.common.service.GeneralInfoMapper;
import com.dilon.filemanagerapp.general.info.administrative.dto.AdministrativeRequest;
import com.dilon.filemanagerapp.general.info.administrative.dto.AdministrativeResponse;
import com.dilon.filemanagerapp.general.info.administrative.model.Administrative;
import com.dilon.filemanagerapp.general.info.administrative.repository.AdministrativeRepository;
import com.dilon.filemanagerapp.general.info.career.dto.CareerRequest;
import com.dilon.filemanagerapp.general.info.career.dto.CareerResponse;
import com.dilon.filemanagerapp.general.info.career.model.Career;
import com.dilon.filemanagerapp.general.info.career.repository.CareerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CareerService extends BaseDocumentService<Career, CareerRequest, CareerResponse> {

    private final CareerRepository careerRepository;

    private final GeneralInfoMapper generalInfoMapper;


    @Override
    protected JpaRepository<Career, Integer> getRepository() {
        return careerRepository;
    }

    @Override
    protected Career mapToEntity(CareerRequest req) {
        return generalInfoMapper.toCareer(req);
    }

    @Override
    protected CareerResponse mapToResponse(Career entity) {
        return generalInfoMapper.toCareerResponse(entity);
    }

    @Override
    protected JpaSpecificationExecutor<Career> getSpecificationExecutor() {
        return careerRepository;
    }
}


