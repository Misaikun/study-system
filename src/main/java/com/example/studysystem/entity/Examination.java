package com.example.studysystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Teacher teacher;

    @ManyToOne()
    @JsonIgnore
    private ClassInfo classInfo;

    @OneToMany(mappedBy = "examination")
    @JsonIgnore
    private List<Score> scores = new ArrayList<Score>();
}
