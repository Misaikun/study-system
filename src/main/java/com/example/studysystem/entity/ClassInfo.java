package com.example.studysystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @author Misaikun
 * @ClassName ClassInfo
 * @description 班级
 * @date 2020/2/18 16:48
 */
public class ClassInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    @JsonIgnoreProperties("classInfos")
    private Grade grade;

    @JoinColumn()//unique=true是指这个字段的值在这张表里不能重复，所有记录值都要唯一，就像主键那样;
    @OneToOne
    private Teacher teacher;
}
