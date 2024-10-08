package com.code_training_app.service;

import com.code_training_app.model.User;
import com.code_training_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByLoginAndPassword(String login, String password) {
        User user = userRepository.findByLoginAndPassword(login, password);
        return user;
    }
}
