package com.code_training_app.repository;

import com.code_training_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginAndPassword(String login, String password);

}
