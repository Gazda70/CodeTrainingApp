package com.code_training_app.repository;

import com.code_training_app.model.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Long> {
    @Query("SELECT qa FROM QuestionAnswer qa JOIN qa.quizSolution qs WHERE qs.quizSolutionId=:quizSolutionId")
    List<QuestionAnswer> getQuestionAnswersByQuizSolutionId(@Param("quizSolutionId") Long quizSolutionId);
}
