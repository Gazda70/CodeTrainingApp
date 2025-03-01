package com.code_training_app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name="quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "quiz_id")
    private Long quizId;

    @Column(name="quiz_name")
    private String quizName;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "quiz_question",
            joinColumns = { @JoinColumn(name = "quiz_id") },
            inverseJoinColumns = { @JoinColumn(name = "question_id") }
    )
    private Set<Question> questions;
}
