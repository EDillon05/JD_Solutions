package com.dilon.filemanagerapp.general.info.career.service;

import com.dilon.filemanagerapp.auth.model.User;
import com.dilon.filemanagerapp.common.service.BaseDocumentService;
import com.dilon.filemanagerapp.common.service.BaseSpecificationBuilder;
import com.dilon.filemanagerapp.general.info.career.dto.CareerRequest;
import com.dilon.filemanagerapp.general.info.career.dto.CareerResponse;
import com.dilon.filemanagerapp.common.dto.PageResponse;
import com.dilon.filemanagerapp.general.info.career.model.Career;
import com.dilon.filemanagerapp.general.info.career.repository.CareerRepository;
import com.dilon.filemanagerapp.common.service.GeneralInfoMapper;
import com.dilon.filemanagerapp.profile.model.Profile;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.dilon.filemanagerapp.general.info.career.service.CareerSpecification.withOwnerId;


@Service
@RequiredArgsConstructor
public class CareerService extends BaseDocumentService<Career, CareerRequest> {

    private final CareerRepository careerRepository;

    private final GeneralInfoMapper generalInfoMapper;


    public PageResponse<CareerResponse> findAllCareersByOwner(int page, int size, Authentication auth) {
        User user = (User) auth.getPrincipal();
        Profile profile = user.getProfile();

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").ascending());
        Page<Career> careers = careerRepository.findAll(withOwnerId(profile.getId()), pageable);

        List<CareerResponse> careerResponses = careers
                .stream()
                .map(generalInfoMapper::toCareerResponse)
                .toList();
        return new PageResponse<>(
                careerResponses,
                careers.getNumber(),
                careers.getSize(),
                careers.getTotalElements(),
                careers.getTotalPages(),
                careers.isFirst(),
                careers.isLast()
        );
    }

//    public List<CareerResponse> findAllCareersByOwner(Authentication auth) {
//        User user = (User) auth.getPrincipal();
//        Profile profile = user.getProfile();
//
//        return careerRepository.findAllCareersByOwner(profile)
//                .stream()
//                .map(generalInfoMapper::toCareerResponse)
//                .collect(Collectors.toList());
//    }

    public CareerResponse findById(Integer careerId, Authentication auth) {
        User user = (User) auth.getPrincipal();
        Profile profile = user.getProfile();

        return careerRepository.findById(careerId)
                .map(generalInfoMapper::toCareerResponse)
                .orElseThrow(() -> new EntityNotFoundException("Career not found with id: " + careerId));
    }

    public void updateCareer(
            @Valid CareerRequest request,
            Authentication auth
    ) {
        User user = (User) auth.getPrincipal();
        Profile profile = user.getProfile();

        var career = this.careerRepository.findById(request.id())
                .orElseThrow(() -> new EntityNotFoundException("Career not found with id: " + request.id()
                ));
        mergeCareer(request, career);
        this.careerRepository.save(career);
    }

    private void mergeCareer(@Valid CareerRequest request, Career career) {
        if (StringUtils.isNotBlank(request.name())) {
            career.setName(request.name());
        }
        if (StringUtils.isNotBlank(request.type())) {
            career.setType(request.type());
        }
        if (StringUtils.isNotBlank(request.description())) {
            career.setDescription(request.description());
        }
        if (StringUtils.isNotBlank(request.country())) {
            career.setCountry(request.country());
        }
        if (request.startedAt() != null) {
            career.setStartedAt(request.startedAt());
        }
        if (request.finishedAt() != null) {
            career.setFinishedAt(request.finishedAt());
        }
        if (StringUtils.isNotBlank(request.comment())) {
            career.setComment(request.comment());
        }
        if (StringUtils.isNotBlank(request.url())) {
            career.setUrl(request.url());
        }
        if (StringUtils.isNotBlank(request.status())) {
            career.setStatus(request.status());
        }
        if (StringUtils.isNotBlank(request.level())) {
            career.setLevel(request.level());
        }
        if (StringUtils.isNotBlank(request.institution())) {
            career.setInstitution(request.institution());
        }
        if (StringUtils.isNotBlank(request.certification_name())) {
            career.setCertification_name(request.certification_name());
        }
        if (StringUtils.isNotBlank(request.licenseId())) {
            career.setLicenseId(request.licenseId());
        }
        if (StringUtils.isNotBlank(request.modality())) {
            career.setModality(request.modality());
        }
        if (request.graduation_date() != null) {
            career.setGraduation_date(request.graduation_date());
        }
    }

    public void deleteCareer(String careerId) {
        if (careerId == null) {
            throw new IllegalArgumentException("Career ID cannot be null");
        }
        Integer id = Integer.valueOf(careerId);
        Career career = careerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Career not found with id: " + id));
        careerRepository.delete(career);
    }

    public PageResponse<CareerResponse> searchByFilters(int page, int size, String keyword, String type, LocalDateTime startedAt, LocalDateTime finishedAt, Authentication auth) {
        User user = (User) auth.getPrincipal();
        Profile profile = user.getProfile();

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").ascending());

        BaseSpecificationBuilder<Career> builder = new BaseSpecificationBuilder<>();
        Specification<Career> spec = builder.buildSpec(keyword, type, startedAt, finishedAt, profile);

        Page<Career> careers = careerRepository.findAll(spec, pageable);

        List<CareerResponse> careerResponses = careers
                .stream()
                .map(generalInfoMapper::toCareerResponse)
                .toList();

        return new PageResponse<>(
                careerResponses,
                careers.getNumber(),
                careers.getSize(),
                careers.getTotalElements(),
                careers.getTotalPages(),
                careers.isFirst(),
                careers.isLast()
        );
    }

    @Override
    protected JpaRepository<Career, Integer> getRepository() {
        return careerRepository;
    }

    @Override
    protected Career mapToEntity(CareerRequest dto) {
        return generalInfoMapper.toCareer(dto);
    }



}


