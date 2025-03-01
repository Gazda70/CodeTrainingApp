package com.code_training_app.repository;

import com.code_training_app.model.QuizSolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizSolutionRepository extends JpaRepository<QuizSolution, Long> {
}
