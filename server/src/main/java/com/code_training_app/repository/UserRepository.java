package com.code_training_app.repository;

import com.code_training_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginAndPassword(String login, String password);

    Optional<User> findByLogin(String login);
}
