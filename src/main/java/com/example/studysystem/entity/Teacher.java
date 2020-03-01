package com.example.studysystem.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

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
    @Column(length = 55,name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @OneToOne(mappedBy = "teacher",cascade = CascadeType.ALL)
    private ClassInfo classInfo;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
