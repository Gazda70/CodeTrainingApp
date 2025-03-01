package com.code_training_app.service;

import com.code_training_app.model.Question;
import com.code_training_app.model.Quiz;
import com.code_training_app.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class QuizService {

    private  QuizRepository quizRepository;

    @Autowired
    public void setQuizRepository(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public void createQuiz(String quizName, Set<Question> questions) {
        Quiz quiz = new Quiz();
        quiz.setQuizName(quizName);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }
}
