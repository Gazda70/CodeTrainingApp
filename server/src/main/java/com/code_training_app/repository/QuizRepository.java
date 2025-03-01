package com.code_training_app.repository;

import com.code_training_app.model.Quiz;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
