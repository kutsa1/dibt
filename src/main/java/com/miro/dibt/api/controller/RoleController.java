package com.miro.dibt.api.controller;

import com.miro.dibt.business.abstracts.IRoleService;
import com.miro.dibt.core.entities.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/role")
@RequiredArgsConstructor
public class RoleController {

    private final IRoleService roleService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid Role role) {
        var result = roleService.add(role);
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(result.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
