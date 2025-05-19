package com.dilon.filemanagerapp.general.info.teaching.controller;

import com.dilon.filemanagerapp.common.controller.BaseDocumentController;
import com.dilon.filemanagerapp.common.dto.PageResponse;
import com.dilon.filemanagerapp.general.info.recognition.dto.RecognitionRequest;
import com.dilon.filemanagerapp.general.info.recognition.dto.RecognitionResponse;
import com.dilon.filemanagerapp.general.info.recognition.service.RecognitionService;
import com.dilon.filemanagerapp.general.info.teaching.dto.TeachingRequest;
import com.dilon.filemanagerapp.general.info.teaching.dto.TeachingResponse;
import com.dilon.filemanagerapp.general.info.teaching.service.TeachingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/teaching")
@Tag(name = "teaching", description = "General Info API")
public class TeachingController extends BaseDocumentController<TeachingRequest, TeachingResponse, TeachingService> {

    public TeachingController(TeachingService service) {
        super(service);
    }
}
