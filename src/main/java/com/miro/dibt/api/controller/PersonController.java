package com.miro.dibt.api.controller;

import com.miro.dibt.core.api.ControllerBase;
import com.miro.dibt.business.abstracts.IPersonService;
import com.miro.dibt.entities.concretes.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/persons")
public class PersonController extends ControllerBase<Person, IPersonService> {

    IPersonService iPersonService;


    public PersonController(IPersonService iPersonService) {
        super(iPersonService);
        this.iPersonService = iPersonService;
    }


}
