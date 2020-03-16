package com.example.studysystem.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
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

public class Examination {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "teacher_id",insertable = false ,updatable = false)
    @JsonBackReference
//    @JsonIgnoreProperties("examinations")
    private Teacher teacher;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "classinfo_id",insertable = false ,updatable = false)
    @JsonBackReference
//    @JsonIgnoreProperties("examinations")
    private ClassInfo classInfo;

    @JsonIgnore
    @OneToMany(mappedBy = "examination",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Score> scores ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

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

    @Override
    public String toString() {
        return "Examination{" +
                "id=" + id +
                ", date=" + date +
                ", name='" + name + '\'' +
                '}';
    }
}
