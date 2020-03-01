package com.example.studysystem.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

/**
 * @author Misaikun
 * @ClassName Student
 * @description
 * @date 2020/1/29 16:13
 */

@Entity
@Data
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 55,name = "name")
    private String name;//账号名
    @Column(name = "password")
    private String password;//密码
    @Column(name = "number")
    private Integer number;//学号
    @Column(name = "class_info")
    @ManyToOne
    private ClassInfo classInfo;//班级

    @OneToMany
    private Student student;

    @OneToOne
    private Teacher teacher;
}
