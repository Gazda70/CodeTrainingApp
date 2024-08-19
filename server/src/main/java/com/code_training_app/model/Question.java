package com.code_training_app.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="question")
public class Question {

    public Question() {}
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="question_id")
    private Long question_id;

//    public void setId(Long id) {
//        this.id = id;
//    }

    public Long getQuestionId() {
        return this.question_id;
    }

    @Column(name="text")
    private String text;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "question_answer",
            joinColumns = { @JoinColumn(name = "question_id") },
            inverseJoinColumns = { @JoinColumn(name = "answer_id") }
    )
    private Set<Answer> answers;

    @Column
    private Long chosenAnswerId;

    @Column
    private Long correctAnswerId;

    public void setCorrectAnswerId(Long correctAnswerId) {
        this.correctAnswerId = correctAnswerId;
    }

    public Long getCorrectAnswerId() { return this.correctAnswerId; }

    public void setChosenAnswerId(Long chosenAnswerId) {
        this.chosenAnswerId = chosenAnswerId;
    }

    public Long getChosenAnswerId() { return this.chosenAnswerId; }
    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public Set<Answer> getAnswers() {
        return this.answers;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

}
