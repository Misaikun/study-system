package com.example.studysystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Misaikun
 * @ClassName Teacher
 * @description teacher
 * @date 2020/1/13 19:39
 */

@Entity
@Data
@Table(name = "teacher")

public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 55, name = "name")
    private String name;
    @Column(name = "password")
    private String password;

    //    @JsonIgnoreProperties("teacher")
    @JsonIgnore
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<ClassInfo> classInfos = new ArrayList<ClassInfo>();

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ChoiceQuestion> choiceQuestions = new ArrayList<ChoiceQuestion>();

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Examination> examinations = new ArrayList<Examination>();
}
