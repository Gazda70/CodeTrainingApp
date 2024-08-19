package com.code_training_app.model;

import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="answer")
public class Answer {

    public Answer() {}

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="answer_id")
    private Long answer_id;

//    public void setId(Long id) {
//        this.id = id;
//    }

    public Long getAnswerId() {
        return this.answer_id;
    }

    @Column(name="text")
    private String text;

    @ManyToMany(mappedBy="answers")
    private Set<Question> questions = new HashSet<>();

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
