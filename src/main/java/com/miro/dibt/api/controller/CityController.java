package com.miro.dibt.api.controller;

import com.miro.dibt.business.abstracts.ICityService;
import com.miro.dibt.core.api.ControllerBase;
import com.miro.dibt.entities.concretes.City;
import com.miro.dibt.repo.abstracts.ICityDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cities")
public class CityController extends ControllerBase<City, ICityService> {

    ICityService iCityService;


    public CityController(ICityService iCityService, ICityDao iCityDao) {
        super(iCityService);
        this.iCityService = iCityService;

    }

}
