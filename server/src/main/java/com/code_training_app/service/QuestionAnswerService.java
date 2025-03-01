package com.code_training_app.service;

import com.code_training_app.model.*;
import com.code_training_app.repository.QuestionAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionAnswerService {

    private QuestionAnswerRepository questionAnswerRepository;

    @Autowired
    public void setQuestionAnswerRepository(QuestionAnswerRepository questionAnswerRepository) {
        this.questionAnswerRepository = questionAnswerRepository;
    }

    public void createQuestionAnswer(Answer answer, Question question, QuizSolution quizSolution) {
        QuestionAnswer questionAnswer = new QuestionAnswer();
        questionAnswer.setAnswer(answer);
        questionAnswer.setQuestion(question);
        questionAnswer.setQuizSolution(quizSolution);
        questionAnswerRepository.save(questionAnswer);
    }
}
