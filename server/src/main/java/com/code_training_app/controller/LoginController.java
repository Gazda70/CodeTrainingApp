package com.code_training_app.controller;

import com.code_training_app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@RestController
@RequestMapping("auth")
public class LoginController {

    private LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Boolean> login(@RequestBody HashMap<String, String> credentials) {
        boolean loggedIn = loginService.login(credentials.get("login"), credentials.get("password"));
        return new ResponseEntity<>(loggedIn, HttpStatus.OK);
    }
}
