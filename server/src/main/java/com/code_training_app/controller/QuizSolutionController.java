package com.code_training_app.controller;

import com.code_training_app.service.QuizSolutionService;
import com.code_training_app.service.exception.NoQuizSolutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/quiz_solution")
public class QuizSolutionController {

    @Autowired
    private QuizSolutionService quizSolutionService;

    @GetMapping("/{userId}/{quizId}")
    public Integer calculateResultForUserAndQuiz(@PathVariable Long userId, @PathVariable Long quizId) throws NoQuizSolutionException {
        return quizSolutionService.calculateQuizResultForUser(userId, quizId);
    }
}
