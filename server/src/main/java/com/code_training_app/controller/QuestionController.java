package com.code_training_app.controller;

import com.code_training_app.model.Question;
import com.code_training_app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping("api")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/example")
    public String displayData() {
        String message = "Welcome to GeeksForGeeks";
        return message;
    }

    @CrossOrigin
    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public ResponseEntity<List<Question>> getQuestions() {
        return new ResponseEntity<>(this.questionService.getQuestions(), HttpStatus.OK);
    }

    @PostMapping(value = "/questions/create")
    public ResponseEntity<String> createQuestion(@RequestParam String text, @RequestParam(required = false) List<String> answerTexts, @RequestParam Long correctAnswerId) {
        this.questionService.insertNewQuestionWithAnswers(text, answerTexts, correctAnswerId);
        return new ResponseEntity<>("Question created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/questions/setQuestionAnswer", method = RequestMethod.PATCH, produces = {"text/plain"})
    public ResponseEntity<String> setQuestionAnswer(@RequestParam Long questionId, @RequestParam Long answerId) {
        this.questionService.updateQuestion(questionId, answerId);
        return new ResponseEntity<>("Question answer set successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/questions/calculateResult", method = RequestMethod.GET)
    public ResponseEntity<Long> calculateResult(@RequestParam String questionIds) {
        try {
            List<Long> ids = Arrays.stream(questionIds.split(",")).map(Long::parseLong).collect(Collectors.toList());
            Long result = questionService.calculatePoints(ids);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            return new ResponseEntity<>(0L, HttpStatus.BAD_REQUEST);
        }
    }

}
