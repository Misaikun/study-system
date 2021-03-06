package com.example.studysystem.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


/**
 * @author Misaikun
 * @ClassName Grade
 * @description 年级
 * @date 2020/2/18 16:47
 */
@Entity
@Table(name = "grade")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Grade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;


    @JsonIgnore
    @OneToMany(mappedBy = "grade",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<ClassInfo> clazzs = new HashSet<>();


    @JsonIgnore
    @OneToMany(mappedBy = "knowledge_grade",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<Knowledge> knowledges = new HashSet<>();

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

    public Set<ClassInfo> getClazzs() {
        return clazzs;
    }

    public void setClazzs(Set<ClassInfo> clazzs) {
        this.clazzs = clazzs;
    }

    public Set<Knowledge> getKnowledges() {
        return knowledges;
    }

    public void setKnowledges(Set<Knowledge> knowledges) {
        this.knowledges = knowledges;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
