package com.dilon.filemanagerapp.general.info.career.controller;

import com.dilon.filemanagerapp.common.controller.BaseDocumentController;
import com.dilon.filemanagerapp.general.info.career.dto.CareerRequest;
import com.dilon.filemanagerapp.general.info.career.dto.CareerResponse;
import com.dilon.filemanagerapp.general.info.career.service.CareerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/careers")
@Tag(name = "career", description = "General Info API")
public class CareerController extends BaseDocumentController<CareerRequest, CareerResponse, CareerService> {

    public CareerController(CareerService service) {
        super(service);
    }
}