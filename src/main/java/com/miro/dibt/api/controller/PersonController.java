package com.miro.dibt.api.controller;

import com.miro.dibt.business.abstracts.IPersonService;
import com.miro.dibt.core.entities.User;
import com.miro.dibt.dataAccess.abstracts.IPersonDao;
import com.miro.dibt.entities.concretes.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/persons")
@RequiredArgsConstructor
public class PersonController {

    private final IPersonService personService;

    @GetMapping("/getall")
    ResponseEntity<?> getall() {
        var result = personService.getAll();
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(result.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    ResponseEntity<?> add(@RequestBody @Valid Person person) {
        var result = personService.add(person);

        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(result.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/delete")
    ResponseEntity<?> delete(@RequestBody Person person) {
        var result = personService.delete(person);
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(result.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/update")
    ResponseEntity<?> update(@RequestBody @Valid Person person) {
        var result = personService.update(person);
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(result.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
