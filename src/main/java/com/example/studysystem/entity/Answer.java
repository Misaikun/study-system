package com.example.studysystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Misaikun
 * @ClassName Answer
 * @description
 * @date 2020/3/24 10:44
 */
@Entity
@Table(name = "answer")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Answer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "examination_id" )
    @JsonIgnoreProperties(ignoreUnknown = true,value={"classInfo","createTime","stareTime","endTime"})
    @JsonBackReference(value = "examination")
    @ManyToOne(cascade=CascadeType.ALL ,fetch = FetchType.EAGER)
    private Examination examination;

    @JoinColumn(name = "choicequestion_id" )
    @JsonIgnoreProperties(ignoreUnknown = true,value = {"knowledge","teacher"})
    @JsonBackReference(value = "choiceQuestion")
    @ManyToOne(cascade=CascadeType.ALL ,fetch = FetchType.EAGER)
    private ChoiceQuestion choiceQuestion;

    @JoinColumn(name = "student_id" )
    @JsonIgnoreProperties(ignoreUnknown = true,value = {"classInfo"})
    @JsonBackReference(value = "choiceQuestion")
    @ManyToOne(cascade=CascadeType.ALL ,fetch = FetchType.EAGER)
    private Student student;
}
