package com.code_training_app.repository;

import com.code_training_app.model.QuizSolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizSolutionRepository extends JpaRepository<QuizSolution, Long> {
    @Query(value = "SELECT * FROM quiz_solution qs WHERE qs.app_user_id = :appUserId", nativeQuery = true)
    QuizSolution getQuizSolutionsByAppUserId(@Param("appUserId") Long appUserId);

    List<QuizSolution> findAllByAppUserId(@Param("appUserId") Long appUserId);

    @Query(value = "SELECT * FROM quiz_solution qs WHERE qs.app_user_id = :appUserId and qs.quiz_id = :quizId", nativeQuery = true)
    QuizSolution getQuizSolutionByAppUserId(@Param("appUserId") Long appUserId, @Param("quizId") Long quizId);
}
