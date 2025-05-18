package com.dilon.filemanagerapp.general.info.career.service;

import com.dilon.filemanagerapp.common.service.BaseDocumentService;
import com.dilon.filemanagerapp.general.info.career.dto.CareerRequest;
import com.dilon.filemanagerapp.general.info.career.dto.CareerResponse;
import com.dilon.filemanagerapp.general.info.career.model.Career;
import com.dilon.filemanagerapp.general.info.career.repository.CareerRepository;
import com.dilon.filemanagerapp.common.service.GeneralInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CareerService extends BaseDocumentService<Career, CareerRequest, CareerResponse> {

    private final CareerRepository careerRepository;

    private final GeneralInfoMapper generalInfoMapper;


//    public PageResponse<CareerResponse> findAllCareersByOwner(int page, int size, Authentication auth) {
//        Users users = (Users) auth.getPrincipal();
//        Profile profile = users.getProfile();
//
//        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").ascending());
//        Page<Career> careers = careerRepository.findAll(withOwnerId(profile.getId()), pageable);
//
//        List<CareerResponse> careerResponses = careers
//                .stream()
//                .map(generalInfoMapper::toCareerResponse)
//                .toList();
//        return new PageResponse<>(
//                careerResponses,
//                careers.getNumber(),
//                careers.getSize(),
//                careers.getTotalElements(),
//                careers.getTotalPages(),
//                careers.isFirst(),
//                careers.isLast()
//        );
//    }

//    public void updateCareer(
//            @Valid CareerRequest request,
//            Authentication auth
//    ) {
//        Users users = (Users) auth.getPrincipal();
//        Profile profile = users.getProfile();
//
//        var career = this.careerRepository.findById(request.id())
//                .orElseThrow(() -> new EntityNotFoundException("Career not found with id: " + request.id()
//                ));
//        mergeCareer(request, career);
//        this.careerRepository.save(career);
//    }
//
//
//    private void mergeCareer(@Valid CareerRequest request, Career career) {
//        if (StringUtils.isNotBlank(request.name())) {
//            career.setName(request.name());
//        }
//        if (StringUtils.isNotBlank(request.type())) {
//            career.setType(request.type());
//        }
//        if (StringUtils.isNotBlank(request.description())) {
//            career.setDescription(request.description());
//        }
//        if (StringUtils.isNotBlank(request.country())) {
//            career.setCountry(request.country());
//        }
//        if (request.startedAt() != null) {
//            career.setStartedAt(request.startedAt());
//        }
//        if (request.finishedAt() != null) {
//            career.setFinishedAt(request.finishedAt());
//        }
//        if (StringUtils.isNotBlank(request.comment())) {
//            career.setComment(request.comment());
//        }
//        if (StringUtils.isNotBlank(request.url())) {
//            career.setUrl(request.url());
//        }
//        if (StringUtils.isNotBlank(request.status())) {
//            career.setStatus(request.status());
//        }
//        if (StringUtils.isNotBlank(request.level())) {
//            career.setLevel(request.level());
//        }
//        if (StringUtils.isNotBlank(request.institution())) {
//            career.setInstitution(request.institution());
//        }
//        if (StringUtils.isNotBlank(request.certification_name())) {
//            career.setCertification_name(request.certification_name());
//        }
//        if (StringUtils.isNotBlank(request.licenseId())) {
//            career.setLicenseId(request.licenseId());
//        }
//        if (StringUtils.isNotBlank(request.modality())) {
//            career.setModality(request.modality());
//        }
//        if (request.graduation_date() != null) {
//            career.setGraduation_date(request.graduation_date());
//        }
//    }

//    public void deleteCareer(String careerId) {
//        if (careerId == null) {
//            throw new IllegalArgumentException("Career ID cannot be null");
//        }
//        Integer id = Integer.valueOf(careerId);
//        Career career = careerRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Career not found with id: " + id));
//        careerRepository.delete(career);
//    }

//    public PageResponse<CareerResponse> searchByFilters(int page, int size, String keyword, String type, LocalDateTime startedAt, LocalDateTime finishedAt, Authentication auth) {
//        Users users = (Users) auth.getPrincipal();
//        Profile profile = users.getProfile();
//
//        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").ascending());
//
//        BaseSpecificationBuilder<Career> builder = new BaseSpecificationBuilder<>();
//        Specification<Career> spec = builder.buildSpec(keyword, type, startedAt, finishedAt, profile);
//
//        Page<Career> careers = careerRepository.findAll(spec, pageable);
//
//        List<CareerResponse> careerResponses = careers
//                .stream()
//                .map(generalInfoMapper::toCareerResponse)
//                .toList();
//
//        return new PageResponse<>(
//                careerResponses,
//                careers.getNumber(),
//                careers.getSize(),
//                careers.getTotalElements(),
//                careers.getTotalPages(),
//                careers.isFirst(),
//                careers.isLast()
//        );
//    }

    @Override
    protected JpaRepository<Career, Integer> getRepository() {
        return careerRepository;
    }

    @Override
    protected JpaSpecificationExecutor<Career> getSpecificationExecutor() {
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


//    @Override
//    protected void merge(CareerRequest req, Career entity) {
//        if (StringUtils.isNotBlank(req.name())) {
//            entity.setName(req.name());
//        }
//        if (StringUtils.isNotBlank(req.type())) {
//            entity.setType(req.type());
//        }
//        if (StringUtils.isNotBlank(req.description())) {
//            entity.setDescription(req.description());
//        }
//        if (StringUtils.isNotBlank(req.country())) {
//            entity.setCountry(req.country());
//        }
//        if (req.startedAt() != null) {
//            entity.setStartedAt(req.startedAt());
//        }
//        if (req.finishedAt() != null) {
//            entity.setFinishedAt(req.finishedAt());
//        }
//        if (StringUtils.isNotBlank(req.comment())) {
//            entity.setComment(req.comment());
//        }
//        if (StringUtils.isNotBlank(req.url())) {
//            entity.setUrl(req.url());
//        }
//        if (StringUtils.isNotBlank(req.status())) {
//            entity.setStatus(req.status());
//        }
//        if (StringUtils.isNotBlank(req.level())) {
//            entity.setLevel(req.level());
//        }
//        if (StringUtils.isNotBlank(req.institution())) {
//            entity.setInstitution(req.institution());
//        }
//        if (StringUtils.isNotBlank(req.certification_name())) {
//            entity.setCertification_name(req.certification_name());
//        }
//        if (StringUtils.isNotBlank(req.licenseId())) {
//            entity.setLicenseId(req.licenseId());
//        }
//        if (StringUtils.isNotBlank(req.modality())) {
//            entity.setModality(req.modality());
//        }
//        if (req.graduation_date() != null) {
//            entity.setGraduation_date(req.graduation_date());
//        }
//    }
}


