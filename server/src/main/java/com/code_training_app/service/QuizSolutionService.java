package com.code_training_app.service;

import com.code_training_app.model.*;
import com.code_training_app.repository.QuestionAnswerRepository;
import com.code_training_app.repository.QuestionRepository;
import com.code_training_app.repository.QuizSolutionRepository;
import com.code_training_app.security.CustomUserDetails;
import com.code_training_app.service.exception.NoQuizSolutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class QuizSolutionService {

    private QuizSolutionRepository quizSolutionRepository;

    private QuestionAnswerRepository questionAnswerRepository;

    private QuestionRepository questionRepository;

    @Autowired
    public void setQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Autowired
    public void setQuizSolutionRepository(QuizSolutionRepository quizSolutionRepository) {
        this.quizSolutionRepository = quizSolutionRepository;
    }

    @Autowired
    public void setQuestionAnswerRepository(QuestionAnswerRepository questionAnswerRepository) {
        this.questionAnswerRepository = questionAnswerRepository;
    }

    public void createQuizSolution(Quiz quiz, Set<QuestionAnswer> questionAnswers, Long result, User solver) {
        QuizSolution quizSolution = new QuizSolution();
        quizSolution.setQuiz(quiz);
        quizSolution.setQuestionAnswers(questionAnswers);
        quizSolution.setResult(result);
        quizSolution.setAppUser(solver);
        quizSolutionRepository.save(quizSolution);
    }


    public List<QuizSolution> getQuizSolutionsForAppUser() {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return quizSolutionRepository.findAllByAppUserId(customUserDetails.getUserId());
    }

    public QuizSolution getQuizSolutionForAppUserAndQuiz(Long userId, Long quizId) {
        return quizSolutionRepository.getQuizSolutionByAppUserId(userId, quizId);
    }

    public Integer calculateQuizResultForUser(Long userId, Long quizId) throws NoQuizSolutionException {
        QuizSolution quizSolution = getQuizSolutionForAppUserAndQuiz(userId, quizId);
        if(quizSolution == null) {
            throw new NoQuizSolutionException();
        }
        List<QuestionAnswer> questionAnswers = questionAnswerRepository.getQuestionAnswersByQuizSolutionId(quizSolution.getQuizSolutionId());
        List<Question> questions = questionRepository.findAllByQuizId(quizId);
        Integer points = 0;
        for(Question question : questions) {
            if(questionAnswers.stream().anyMatch(qa -> qa.getQuestion().getQuestionId().equals(question.getQuestionId())
                && qa.getQuestion().getCorrectAnswerId().equals(question.getCorrectAnswerId())
            )) {
                points++;
            }
        }
        return points;
    }
}
