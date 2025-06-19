package com.code_training_app.repository;

import com.code_training_app.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query("SELECT q FROM Question q JOIN q.quizzes z WHERE z.quizId = :quizId")
    List<Question> findAllByQuizId(@Param("quizId") Long quizId);
}
