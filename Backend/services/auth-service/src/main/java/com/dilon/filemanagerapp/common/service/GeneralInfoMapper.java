package com.dilon.filemanagerapp.common.service;

import com.dilon.filemanagerapp.general.info.administrative.dto.AdministrativeRequest;
import com.dilon.filemanagerapp.general.info.administrative.dto.AdministrativeResponse;
import com.dilon.filemanagerapp.general.info.administrative.model.Administrative;
import com.dilon.filemanagerapp.general.info.career.dto.CareerRequest;
import com.dilon.filemanagerapp.general.info.career.dto.CareerResponse;
import com.dilon.filemanagerapp.general.info.experience.dto.ExperienceRequest;
import com.dilon.filemanagerapp.general.info.experience.dto.ExperienceResponse;
import com.dilon.filemanagerapp.general.info.career.model.Career;
import com.dilon.filemanagerapp.general.info.experience.model.Experience;
import com.dilon.filemanagerapp.general.info.project.dto.ProjectRequest;
import com.dilon.filemanagerapp.general.info.project.dto.ProjectResponse;
import com.dilon.filemanagerapp.general.info.project.model.Project;
import com.dilon.filemanagerapp.general.info.research.dto.ResearchRequest;
import com.dilon.filemanagerapp.general.info.research.dto.ResearchResponse;
import com.dilon.filemanagerapp.general.info.research.model.Research;
import com.dilon.filemanagerapp.general.info.teaching.dto.TeachingRequest;
import com.dilon.filemanagerapp.general.info.teaching.dto.TeachingResponse;
import com.dilon.filemanagerapp.general.info.teaching.model.Teaching;
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

    public Teaching toTeaching(TeachingRequest req) {
        if (req == null) {
            return null;
        }
        return Teaching.builder()
                .name(req.name())
                .type(req.type())
                .description(req.description())
                .country(req.country())
                .startedAt(req.startedAt())
                .finishedAt(req.finishedAt())
                .comment(req.comment())
                .url(req.url())
                .status(req.status())
                .assessmentName(req.assessmentName())
                .programName(req.programName())
                .level(req.level())
                .institution(req.institution())
                .modality(req.modality())
                .weeklyHours(req.weeklyHours())
                .build();
    }

    public TeachingResponse toTeachingResponse(Teaching entity) {
        if (entity == null) {
            return null;
        }
        return new TeachingResponse(
                entity.getId(),
                entity.getName(),
                entity.getType(),
                entity.getDescription(),
                entity.getCountry(),
                entity.getStartedAt(),
                entity.getFinishedAt(),
                entity.getComment(),
                entity.getUrl(),
                entity.getStatus(),
                entity.getAssessmentName(),
                entity.getProgramName(),
                entity.getLevel(),
                entity.getInstitution(),
                entity.getModality(),
                entity.getWeeklyHours()
        );
    }

    public Administrative toAdministrative(AdministrativeRequest req) {
        if (req == null) {
            return null;
        }
        return Administrative.builder()
                .name(req.name())
                .type(req.type())
                .description(req.description())
                .country(req.country())
                .startedAt(req.startedAt())
                .finishedAt(req.finishedAt())
                .comment(req.comment())
                .url(req.url())
                .status(req.status())
                .position(req.position())
                .academicUnit(req.academicUnit())
                .institution(req.institution())
                .level(req.level())
                .modality(req.modality())
                .build();
    }

    public AdministrativeResponse toAdministrativeResponse(Administrative entity) {
        if (entity == null) {
            return null;
        }
        return new AdministrativeResponse(
                entity.getId(),
                entity.getName(),
                entity.getType(),
                entity.getDescription(),
                entity.getCountry(),
                entity.getStartedAt(),
                entity.getFinishedAt(),
                entity.getComment(),
                entity.getUrl(),
                entity.getStatus(),
                entity.getPosition(),
                entity.getAcademicUnit(),
                entity.getInstitution(),
                entity.getLevel(),
                entity.getModality()
        );
    }

    public Research toResearch(ResearchRequest req) {
        if (req == null) {
            return null;
        }
        return Research.builder()
                .name(req.name())
                .type(req.type())
                .description(req.description())
                .country(req.country())
                .startedAt(req.startedAt())
                .finishedAt(req.finishedAt())
                .comment(req.comment())
                .url(req.url())
                .status(req.status())
                .publicationType(req.publicationType())
                .publicationTitle(req.publicationTitle())
                .magazineName(req.magazineName())
                .publicationDate(req.publicationDate())
                .doi(req.doi())
                .isbn(req.isbn())
                .eventName(req.eventName())
                .build();
    }

    public ResearchResponse toResearchResponse(Research entity) {
        if (entity == null) {
            return null;
        }
        return new ResearchResponse(
                entity.getId(),
                entity.getName(),
                entity.getType(),
                entity.getDescription(),
                entity.getCountry(),
                entity.getStartedAt(),
                entity.getFinishedAt(),
                entity.getComment(),
                entity.getUrl(),
                entity.getStatus(),
                entity.getPublicationType(),
                entity.getPublicationTitle(),
                entity.getMagazineName(),
                entity.getPublicationDate(),
                entity.getDoi(),
                entity.getIsbn(),
                entity.getEventName()
        );
    }

    public Project toProject(ProjectRequest req) {
        if (req == null) {
            return null;
        }
        return Project.builder()
                .name(req.name())
                .type(req.type())
                .description(req.description())
                .country(req.country())
                .startedAt(req.startedAt())
                .finishedAt(req.finishedAt())
                .comment(req.comment())
                .url(req.url())
                .status(req.status())
                .role(req.role())
                .institutionName(req.institutionName())
                .budget(req.budget())
                .projectLink(req.projectLink())
                .publicationDate(req.publicationDate())
                .disciplinaryArea(req.disciplinaryArea())
                .build();
    }

    public ProjectResponse toProjectResponse(Project entity) {
        if (entity == null) {
            return null;
        }
        return new ProjectResponse(
                entity.getId(),
                entity.getName(),
                entity.getType(),
                entity.getDescription(),
                entity.getCountry(),
                entity.getStartedAt(),
                entity.getFinishedAt(),
                entity.getComment(),
                entity.getUrl(),
                entity.getStatus(),
                entity.getRole(),
                entity.getInstitutionName(),
                entity.getBudget(),
                entity.getProjectLink(),
                entity.getPublicationDate(),
                entity.getDisciplinaryArea()
        );
    }
}
