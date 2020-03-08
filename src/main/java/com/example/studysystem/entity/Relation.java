package com.example.studysystem.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Misaikun
 * @ClassName Relation
 * @description 知识点之间的关系
 * @date 2020/3/8 21:00
 */
@Entity
@Data
@Table(name = "relation")
public class Relation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
