package com.dilon.filemanagerapp.general.info.administrative.controller;

import com.dilon.filemanagerapp.common.controller.BaseDocumentController;
import com.dilon.filemanagerapp.general.info.administrative.dto.AdministrativeRequest;
import com.dilon.filemanagerapp.general.info.administrative.dto.AdministrativeResponse;
import com.dilon.filemanagerapp.general.info.administrative.service.AdministrativeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrative")
@Tag(name = "General Info", description = "General Info API")
public class AdministrativeController extends BaseDocumentController<AdministrativeRequest, AdministrativeResponse, AdministrativeService> {

    public AdministrativeController(AdministrativeService service) {
        super(service);
    }
}
