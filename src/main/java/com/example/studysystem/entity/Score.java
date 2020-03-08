package com.example.studysystem.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Misaikun
 * @ClassName Score
 * @description
 * @date 2020/3/8 21:25
 */

@Entity
@Data
@Table(name = "score")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer num;

    @ManyToOne
    private Examination examination;

    @ManyToOne
    private Student student;



}
