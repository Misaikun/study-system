package com.example.studysystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Misaikun
 * @ClassName Knowledge
 * @description 知识点
 * @date 2020/3/8 20:42
 */

@Entity
@Table(name = "knowledge")
@Data
public class Knowledge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    private Grade grade;

    @OneToMany(mappedBy = "knowledge")
    private List<ChoiceQuestion> choiceQuestions = new ArrayList<ChoiceQuestion>();
}
