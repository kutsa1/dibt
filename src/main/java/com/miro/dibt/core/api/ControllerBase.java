package com.miro.dibt.core.api;

import com.miro.dibt.core.entities.IEntity;
import com.miro.dibt.core.utilities.business.IServiceBase;
import com.miro.dibt.entities.concretes.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@RequiredArgsConstructor
public class ControllerBase<T extends IEntity, ServiceBase extends IServiceBase<T>> {

    private final ServiceBase serviceBase;

    @GetMapping("/getall")
    ResponseEntity<?> getall() {
        var result = serviceBase.getAll();
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(result.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    ResponseEntity<?> add(@RequestBody @Valid T t) {
        var result = serviceBase.add(t);

        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(result.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/delete")
    ResponseEntity<?> delete(@RequestBody T t) {
        var result = serviceBase.delete(t);
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(result.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/update")
    ResponseEntity<?> update(@RequestBody @Valid T t) {
        var result = serviceBase.update(t);
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(result.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
