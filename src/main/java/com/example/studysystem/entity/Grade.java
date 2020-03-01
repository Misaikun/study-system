package com.example.studysystem.entity;

import lombok.Data;

import javax.persistence.*;

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
    @OneToMany
    private ClassInfo classInfo;
}
