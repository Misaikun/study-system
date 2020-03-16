package com.example.studysystem.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Misaikun
 * @ClassName Teacher
 * @description teacher
 * @date 2020/1/13 19:39
 */

@Entity
@Table(name = "teacher")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 55, name = "name")
    private String name;
    @Column(name = "password")
    private String password;

    @JsonIgnore
    //    @JsonIgnoreProperties("teacher")
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<ClassInfo> classInfos  ;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<ChoiceQuestion> choiceQuestions ;


    @JsonIgnore
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Examination> examinations ;

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Message> messages = new HashSet<>();

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<ClassInfo> getClassInfos() {
        return classInfos;
    }

    public void setClassInfos(Set<ClassInfo> classInfos) {
        this.classInfos = classInfos;
    }

    public Set<ChoiceQuestion> getChoiceQuestions() {
        return choiceQuestions;
    }

    public void setChoiceQuestions(Set<ChoiceQuestion> choiceQuestions) {
        this.choiceQuestions = choiceQuestions;
    }

    public Set<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(Set<Examination> examinations) {
        this.examinations = examinations;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
