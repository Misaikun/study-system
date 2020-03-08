package com.example.studysystem.entity;

import io.swagger.annotations.Api;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Misaikun
 * @ClassName Question
 * @description
 * @date 2020/3/6 22:54
 */
@Data
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


}
