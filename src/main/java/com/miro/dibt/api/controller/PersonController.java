package com.miro.dibt.api.controller;

import com.miro.dibt.business.abstracts.IPersonService;
import com.miro.dibt.core.api.ControllerBase;
import com.miro.dibt.core.utilities.results.ErrorResult;
import com.miro.dibt.entities.concretes.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/persons")
public class PersonController extends ControllerBase<Person, IPersonService> {

    IPersonService iPersonService;


    public PersonController(IPersonService iPersonService) {
        super(iPersonService);
        this.iPersonService = iPersonService;
    }

    @GetMapping("/findbyusernameandpassword")
    ResponseEntity<?> findByUsernameAndPassword(@RequestParam String username, String password) {
        var result = iPersonService.findByUsernameAndPassword(username, password);
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(new ErrorResult(result.getMessage()), HttpStatus.BAD_REQUEST);
    }


}
