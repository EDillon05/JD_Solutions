package com.dilon.filemanagerapp.common.service;

import com.dilon.filemanagerapp.general.info.career.dto.CareerRequest;
import com.dilon.filemanagerapp.general.info.career.dto.CareerResponse;
import com.dilon.filemanagerapp.general.info.experience.dto.ExperienceRequest;
import com.dilon.filemanagerapp.general.info.experience.dto.ExperienceResponse;
import com.dilon.filemanagerapp.general.info.career.model.Career;
import com.dilon.filemanagerapp.general.info.experience.model.Experience;
import org.springframework.stereotype.Component;

@Component
public class GeneralInfoMapper {
    public Career toCareer(CareerRequest careerRequest) {
        if (careerRequest == null) {
            return null;
        }
        return Career.builder()
                .name(careerRequest.name())
                .type(careerRequest.type())
                .description(careerRequest.description())
                .country(careerRequest.country())
                .startedAt(careerRequest.startedAt())
                .finishedAt(careerRequest.finishedAt())
                .comment(careerRequest.comment())
                .url(careerRequest.url())
                .status(careerRequest.status())
                .level(careerRequest.level())
                .institution(careerRequest.institution())
                .certification_name(careerRequest.certification_name())
                .licenseId(careerRequest.licenseId())
                .modality(careerRequest.modality())
                .graduation_date(careerRequest.graduation_date())
                .build();
    }

    public Experience toExperience(ExperienceRequest experienceRequest){
        if (experienceRequest == null) {
            return null;
        }
        return Experience.builder()
                .name(experienceRequest.name())
                .type(experienceRequest.type())
                .description(experienceRequest.description())
                .country(experienceRequest.country())
                .startedAt(experienceRequest.startedAt())
                .finishedAt(experienceRequest.finishedAt())
                .comment(experienceRequest.comment())
                .url(experienceRequest.url())
                .status(experienceRequest.status())
                .companyName(experienceRequest.companyName())
                .position(experienceRequest.position())
                .area(experienceRequest.area())
                .contractType(experienceRequest.contractType())
                .build();
    }

    public ExperienceResponse toExperienceResponse(Experience experience) {
        if (experience == null) {
            return null;
        }
        return new ExperienceResponse(
                experience.getId(),
                experience.getName(),
                experience.getType(),
                experience.getDescription(),
                experience.getCountry(),
                experience.getStartedAt(),
                experience.getFinishedAt(),
                experience.getComment(),
                experience.getUrl(),
                experience.getStatus(),
                experience.getCompanyName(),
                experience.getPosition(),
                experience.getArea(),
                experience.getContractType()
        );
    }

    public CareerResponse toCareerResponse(Career career) {
        if (career == null) {
            return null;
        }
        return new CareerResponse(
                career.getId(),
                career.getName(),
                career.getType(),
                career.getDescription(),
                career.getCountry(),
                career.getStartedAt(),
                career.getFinishedAt(),
                career.getComment(),
                career.getUrl(),
                career.getStatus(),
                career.getLevel(),
                career.getInstitution(),
                career.getCertification_name(),
                career.getLicenseId(),
                career.getModality(),
                career.getGraduation_date()
        );
    }
}
