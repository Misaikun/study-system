package com.example.studysystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Misaikun
 * @ClassName ClassInfo
 * @description 班级
 * @date 2020/2/18 16:48
 */
@Entity
@Data
@Table(name = "classinfo")
public class ClassInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne()
//    @JsonIgnoreProperties("clazzs")
    @JsonIgnore
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @JsonIgnore
    @JoinColumn()//unique=true是指这个字段的值在这张表里不能重复，所有记录值都要唯一，就像主键那样;
    @ManyToOne
    private Teacher teacher;

    @OneToMany(mappedBy = "classInfo")
    @JsonIgnore
    private List<Student> students = new ArrayList<Student>();

    @OneToMany(mappedBy = "classInfo")
    @JsonIgnore
    private List<Examination> examinations = new ArrayList<Examination>();
}
