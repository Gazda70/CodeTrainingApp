package com.code_training_app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="question_answer")
public class QuestionAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_answer_id")
    private Long questionAnswerId;

    @OneToOne
    @PrimaryKeyJoinColumn(name="question")
    private Question question;

    @OneToOne
    @PrimaryKeyJoinColumn(name="answer")
    private Answer answer;

    @ManyToOne
    @JoinColumn(name="quiz_solution")
    private QuizSolution quizSolution;


}
