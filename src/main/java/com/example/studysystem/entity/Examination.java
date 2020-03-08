package com.example.studysystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Misaikun
 * @ClassName Examination
 * @description 试卷
 * @date 2020/3/8 21:24
 */
@Entity
@Table(name = "examination")
@Data
public class Examination {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String name;

    @ManyToOne()
    private Teacher teacher;

    @ManyToOne()
    private ClassInfo classInfo;

    @OneToMany(mappedBy = "examination")
    private List<Score> scores = new ArrayList<Score>();
}
