package com.miro.dibt.api.controller;

import com.miro.dibt.business.abstracts.IUserService;
import com.miro.dibt.entities.concretes.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private final IUserService userService;

    @GetMapping("/getall")
    ResponseEntity<?> getall() {
        var result = userService.getAll();
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(result.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    ResponseEntity<?> add(User user) {
        var result = userService.add(user);
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(result.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/delete")
    ResponseEntity<?> delete(User user) {
        var result = userService.delete(user);
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(result.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/update")
    ResponseEntity<?> update(User user) {
        var result = userService.update(user);
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(result.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
