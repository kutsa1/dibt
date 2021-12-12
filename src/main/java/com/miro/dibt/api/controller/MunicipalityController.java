package com.miro.dibt.api.controller;

import com.miro.dibt.business.abstracts.IMunicipalityService;
import com.miro.dibt.core.api.ControllerBase;
import com.miro.dibt.entities.concretes.Municipality;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/municipalities")
public class MunicipalityController extends ControllerBase<Municipality, IMunicipalityService> {

    IMunicipalityService iMunicipalityService;

    public MunicipalityController(IMunicipalityService iMunicipalityService) {
        super(iMunicipalityService);
        this.iMunicipalityService = iMunicipalityService;
    }
}
