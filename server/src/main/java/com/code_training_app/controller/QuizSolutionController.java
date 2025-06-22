package com.code_training_app.controller;

import com.code_training_app.model.QuizSolution;
import com.code_training_app.service.QuizSolutionService;
import com.code_training_app.service.exception.NoQuizSolutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path="/api/quiz_solution")
public class QuizSolutionController {

    @Autowired
    private QuizSolutionService quizSolutionService;

    @GetMapping("/{userId}/{quizId}")
    public Integer calculateResultForUserAndQuiz(@PathVariable Long userId, @PathVariable Long quizId) throws NoQuizSolutionException {
        return quizSolutionService.calculateQuizResultForUser(userId, quizId);
    }

    @GetMapping("/for_current_user")
    public List<QuizSolution> getQuizSolutionsForUser() {
        return quizSolutionService.getQuizSolutionsForAppUser();
    }


}
