package com.example.studysystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.*;


/**
 * @author Misaikun
 * @ClassName Grade
 * @description 年级
 * @date 2020/2/18 16:47
 */
@Entity
@Table(name = "grade")
@Data
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "grade",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<ClassInfo> clazzs = new HashSet<>();

    @OneToMany(mappedBy = "grade",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private List<Knowledge> knowledges = new ArrayList<Knowledge>();

//    @JsonIgnore
//    @OneToOne()
//    private List<Question> questions = new ArrayList<Question>();
}
