package com.dilon.filemanagerapp.general.info.recognition.controller;

import com.dilon.filemanagerapp.common.controller.BaseDocumentController;
import com.dilon.filemanagerapp.general.info.project.dto.ProjectRequest;
import com.dilon.filemanagerapp.general.info.project.dto.ProjectResponse;
import com.dilon.filemanagerapp.general.info.project.service.ProjectService;
import com.dilon.filemanagerapp.general.info.recognition.dto.RecognitionRequest;
import com.dilon.filemanagerapp.general.info.recognition.dto.RecognitionResponse;
import com.dilon.filemanagerapp.general.info.recognition.service.RecognitionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recognitions")
@Tag(name = "recognition", description = "General Info API")
public class RecognitionController extends BaseDocumentController<RecognitionRequest, RecognitionResponse, RecognitionService> {

    public RecognitionController(RecognitionService service) {
        super(service);
    }
}