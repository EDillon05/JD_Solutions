package com.dilon.filemanagerapp.general.info.experience.controller;

import com.dilon.filemanagerapp.common.controller.BaseDocumentController;
import com.dilon.filemanagerapp.common.dto.PageResponse;
import com.dilon.filemanagerapp.general.info.administrative.dto.AdministrativeRequest;
import com.dilon.filemanagerapp.general.info.administrative.dto.AdministrativeResponse;
import com.dilon.filemanagerapp.general.info.administrative.service.AdministrativeService;
import com.dilon.filemanagerapp.general.info.experience.dto.ExperienceRequest;
import com.dilon.filemanagerapp.general.info.experience.dto.ExperienceResponse;
import com.dilon.filemanagerapp.general.info.experience.service.ExperienceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/experience")
@Tag(name = "experience", description = "General Info API")
public class ExperienceController extends BaseDocumentController<ExperienceRequest, ExperienceResponse, ExperienceService> {

    public ExperienceController(ExperienceService service) {
        super(service);
    }
}
