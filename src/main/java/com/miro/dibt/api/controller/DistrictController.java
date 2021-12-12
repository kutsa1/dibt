package com.miro.dibt.api.controller;

import com.miro.dibt.business.abstracts.IDisctrictService;
import com.miro.dibt.core.api.ControllerBase;
import com.miro.dibt.entities.concretes.District;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/districtes")
public class DistrictController extends ControllerBase<District, IDisctrictService> {

    IDisctrictService iDisctrictService;

    public DistrictController(IDisctrictService iDisctrictService) {
        super(iDisctrictService);
        this.iDisctrictService=iDisctrictService;
    }
}
