package com.example.studysystem.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Misaikun
 * @ClassName ClassInfo
 * @description 班级
 * @date 2020/2/18 16:48
 */
@Entity
@Table(name = "classinfo")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ClassInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "grade_id",insertable = true ,updatable = false)
    @JsonBackReference
    private Grade grade;

    @JsonIgnore
    @JoinColumn(name = "teacher_id",insertable = true ,updatable = false)
    @JsonBackReference
    @ManyToOne(cascade=CascadeType.ALL ,fetch = FetchType.EAGER)
    private Teacher teacher;

    @OneToMany(mappedBy = "classInfo",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Student> students ;

    @OneToMany(mappedBy = "classInfo",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Examination> examinations ;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher", cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Message> messages ;


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
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Set<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(Set<Examination> examinations) {
        this.examinations = examinations;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
