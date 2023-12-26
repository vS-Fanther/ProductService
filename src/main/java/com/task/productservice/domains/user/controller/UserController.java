package com.task.productservice.domains.user.controller;

import com.task.productservice.domains.user.model.dto.AddUserDTO;
import com.task.productservice.domains.user.model.dto.AuthenticateUserDTO;
import com.task.productservice.domains.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody AddUserDTO addUserDTO) {
        userService.addUser(addUserDTO);
        return ResponseEntity.ok("User created Successfully");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticateUser(@RequestBody AuthenticateUserDTO authenticateUserDTO) {
        String jwtToken = userService.authenticateUser(authenticateUserDTO);
        return ResponseEntity.ok(jwtToken);
    }
}
