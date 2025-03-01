package com.code_training_app.service;

import com.code_training_app.model.*;
import com.code_training_app.repository.QuizSolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class QuizSolutionService {

    private QuizSolutionRepository quizSolutionRepository;

    @Autowired
    public void setQuizSolutionRepository(QuizSolutionRepository quizSolutionRepository) {
        this.quizSolutionRepository = quizSolutionRepository;
    }

    public void createQuizSolution(Quiz quiz, Set<QuestionAnswer> questionAnswers, Long result, User solver) {
        QuizSolution quizSolution = new QuizSolution();
        quizSolution.setQuiz(quiz);
        quizSolution.setQuestionAnswers(questionAnswers);
        quizSolution.setResult(result);
        quizSolution.setSolver(solver);
        quizSolutionRepository.save(quizSolution);
    }
}
