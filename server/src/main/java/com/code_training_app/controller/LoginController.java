package com.code_training_app.controller;

import com.code_training_app.model.User;
import com.code_training_app.service.LoginService;
import com.code_training_app.service.jwt.JwtGeneratorImpl;
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

    private JwtGeneratorImpl jwtGenerator;

    @Autowired
    public void setJwtGenerator(JwtGeneratorImpl jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody HashMap<String, String> credentials) {
        try {
            User userData = loginService.findByLoginAndPassword(credentials.get("username"), credentials.get("password"));
            if (userData == null) {
                throw new UserNotFoundException("Login or Password is Invalid");
            }
            return new ResponseEntity<>(jwtGenerator.generateToken(userData), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
