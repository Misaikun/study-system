package com.example.studysystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private String password;//密码
    private Integer number;//学号
    @JsonIgnore
    @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "classinfo_id")
    private ClassInfo classInfo;//班级

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<Score> scores = new ArrayList<Score>();
}
