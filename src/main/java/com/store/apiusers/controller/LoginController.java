package com.store.apiusers.controller;

import com.store.apiusers.dto.UserLoginDto;
import com.store.apiusers.model.User;
import com.store.apiusers.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("store/v1/login")
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity doLogin(@RequestBody UserLoginDto userLoginDto) {
        loginService.doLogin(userLoginDto);
        return new ResponseEntity(HttpStatus.OK);
    }

}
