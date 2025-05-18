package com.dilon.filemanagerapp.general.info.research.controller;

import com.dilon.filemanagerapp.common.controller.BaseDocumentController;
import com.dilon.filemanagerapp.general.info.research.dto.ResearchRequest;
import com.dilon.filemanagerapp.general.info.research.dto.ResearchResponse;
import com.dilon.filemanagerapp.general.info.research.service.ResearchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/researches")
@Tag(name = "research", description = "General Info API")
public class ResearchController extends BaseDocumentController<ResearchRequest, ResearchResponse, ResearchService> {

    public ResearchController(ResearchService service) {
        super(service);
    }
}
