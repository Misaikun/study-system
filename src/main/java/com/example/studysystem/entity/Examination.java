package com.example.studysystem.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * @author Misaikun
 * @ClassName Examination
 * @description 试卷
 * @date 2020/3/8 21:24
 */
@Entity
@Table(name = "examination")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Examination implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date stareTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnoreProperties
    @JoinColumn(name = "classinfo_id")
    @JsonBackReference(value = "classInfo")
    private ClassInfo classInfo;

    @JsonIgnoreProperties
    @OneToMany(mappedBy = "examination",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Score> scores ;

    @JsonIgnoreProperties
    @OneToMany(mappedBy = "examination",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<ExaminationContent> examinationContents;

//    @JsonIgnoreProperties
//    @OneToMany(mappedBy = "examination",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    private Set<Answer> answers;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStareTime() {
        return stareTime;
    }

    public void setStareTime(Date stareTime) {
        this.stareTime = stareTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Teacher getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }

    public ClassInfo getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }

    public Set<ExaminationContent> getExaminationContents() {
        return examinationContents;
    }

    public void setExaminationContents(Set<ExaminationContent> examinationContents) {
        this.examinationContents = examinationContents;
    }

//    public Set<Answer> getAnswers() {
//        return answers;
//    }
//
//    public void setAnswers(Set<Answer> answers) {
//        this.answers = answers;
//    }

    @Override
    public String toString() {
        return "Examination{" +
                "id=" + id +
                ", create=" + createTime +
                ", name='" + name + '\'' +
                ", star='" + stareTime + '\'' +
                ", end='" + endTime + '\'' +
                '}';
    }
}
