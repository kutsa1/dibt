package com.miro.dibt.api.controller;

import com.miro.dibt.business.abstracts.IRoleService;
import com.miro.dibt.core.api.ControllerBase;
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
public class RoleController extends ControllerBase<Role, IRoleService> {

    private final IRoleService iRoleService;

    public RoleController(IRoleService iRoleService) {
        super(iRoleService);
        this.iRoleService = iRoleService;
    }


}
