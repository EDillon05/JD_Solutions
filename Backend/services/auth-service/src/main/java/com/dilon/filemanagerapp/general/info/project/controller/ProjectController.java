package com.dilon.filemanagerapp.general.info.project.controller;

import com.dilon.filemanagerapp.common.controller.BaseDocumentController;
import com.dilon.filemanagerapp.general.info.project.dto.ProjectRequest;
import com.dilon.filemanagerapp.general.info.project.dto.ProjectResponse;
import com.dilon.filemanagerapp.general.info.project.service.ProjectService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
@Tag(name = "General Info", description = "General Info API")
public class ProjectController extends BaseDocumentController<ProjectRequest, ProjectResponse, ProjectService> {

    public ProjectController(ProjectService service) {
        super(service);
    }
}