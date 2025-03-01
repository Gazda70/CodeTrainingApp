package com.code_training_app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name="quiz_solution")
public class QuizSolution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="quiz_solution_id")
    private Long quizSolutionId;

    @OneToOne
    @PrimaryKeyJoinColumn(name="quiz")
    private Quiz quiz;

    @OneToMany
    @Column(name="question_answers")
    private Set<QuestionAnswer> questionAnswers;

    @OneToOne
    @PrimaryKeyJoinColumn(name="solver")
    private User solver;

    @Column(name="result")
    private Long result;

}
