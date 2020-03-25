package com.example.studysystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

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

    private String content;

    private Integer num;

    @JoinColumn(name = "answer_examinationContent_id" )
    @JsonIgnoreProperties(ignoreUnknown = true,value = {"examination","choiceQuestion"})
    @JsonBackReference(value = "examinationContent")
    @ManyToOne(fetch = FetchType.EAGER)
    private ExaminationContent examinationContent;

    @JoinColumn(name = "answer_student_id" )
    @JsonIgnoreProperties(ignoreUnknown = true,value = {"classInfo"})
    @JsonBackReference(value = "student")
    @ManyToOne(fetch = FetchType.EAGER)
    private Student student;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ExaminationContent getExaminationContent() {
        return examinationContent;
    }

    public void setExaminationContent(ExaminationContent examinationContent) {
        this.examinationContent = examinationContent;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
