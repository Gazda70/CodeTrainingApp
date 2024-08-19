package com.code_training_app.service;

import com.code_training_app.model.Answer;
import com.code_training_app.model.Question;
import com.code_training_app.repository.AnswerRepository;
import com.code_training_app.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    private AnswerRepository answerRepository;

    @Autowired
    private void setQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Autowired
    private void setAnswerRepository(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Question> getQuestions() {
        return this.questionRepository.findAll();
    }

    public void insertNewQuestionWithAnswers(String text, List<String> answerTexts, Long correctAnswerId) {
        Question newQuestion = new Question();
        newQuestion.setText(text);
        newQuestion.setCorrectAnswerId(correctAnswerId);
        newQuestion.setAnswers(answerTexts.stream().map(aT -> {
            Answer answer = new Answer();
            answer.setText(aT);
            this.answerRepository.save(answer);
            return answer;
        }).collect(Collectors.toSet()));
        this.questionRepository.save(newQuestion);
    }

    public void updateQuestion(Long questionId, Long answerId) {
        Question toUpdate = this.questionRepository.findById(questionId).orElseThrow();
        toUpdate.setChosenAnswerId(answerId);
        this.questionRepository.save(toUpdate);
    }

    public Long calculatePoints(List<Long> questionIds) {
        return questionIds.stream().mapToLong(id -> {
            Question question = this.questionRepository.findById(id).orElseThrow();
            if (question.getCorrectAnswerId() != null && question.getChosenAnswerId() != null &&
                    question.getCorrectAnswerId().equals(question.getChosenAnswerId())) {
                return 1;
            }
            return 0;
        }).sum();
    }
}
