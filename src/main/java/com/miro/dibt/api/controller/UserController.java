package com.miro.dibt.api.controller;

import com.miro.dibt.business.abstracts.IUserService;
import com.miro.dibt.core.api.ControllerBase;
import com.miro.dibt.core.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController extends ControllerBase<User, IUserService> {

    private final IUserService iUserService;

    public UserController(IUserService iUserService) {
        super(iUserService);
        this.iUserService = iUserService;
    }


    @PostMapping("/addroletouser")
    public ResponseEntity<?> addRoleToUser(@RequestParam String username, String roleName) {
        var result = iUserService.addRoleToUser(username, roleName);
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(result.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getuserdetail")
    ResponseEntity<?> getUserDetailDto(@RequestParam String username) {
        var result = iUserService.getUserDetailDto(username);
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(result.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
