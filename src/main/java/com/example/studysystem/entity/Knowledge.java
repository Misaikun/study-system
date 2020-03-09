package com.example.studysystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Grade grade;

    @OneToMany(mappedBy = "knowledge")
    @JsonIgnore
    private List<ChoiceQuestion> choiceQuestions = new ArrayList<ChoiceQuestion>();
}
