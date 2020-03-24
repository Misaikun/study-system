package com.example.studysystem.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Misaikun
 * @ClassName Knowledge
 * @description 知识点
 * @date 2020/3/8 20:42
 */

@Entity
@Table(name = "knowledge")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Knowledge implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "knowledge_grade_id")
    @JsonBackReference
    private Grade knowledge_grade;

    @JsonIgnore
    @OneToMany(mappedBy = "knowledge",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<ChoiceQuestion> choiceQuestions = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return knowledge_grade;
    }

    public void setGrade(Grade grade) {
        this.knowledge_grade = grade;
    }

    public Set<ChoiceQuestion> getChoiceQuestions() {
        return choiceQuestions;
    }

    public void setChoiceQuestions(Set<ChoiceQuestion> choiceQuestions) {
        this.choiceQuestions = choiceQuestions;
    }

    @Override
    public String toString() {
        return "Knowledge{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
