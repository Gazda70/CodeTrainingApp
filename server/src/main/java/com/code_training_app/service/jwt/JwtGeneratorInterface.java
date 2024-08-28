package com.code_training_app.service.jwt;

import com.code_training_app.model.User;

import java.util.Map;

public interface JwtGeneratorInterface {

    Map<String, String> generateToken(User user);
}
