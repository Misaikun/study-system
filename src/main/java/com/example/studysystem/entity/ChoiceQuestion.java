package com.example.studysystem.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Misaikun
 * @ClassName ChoiceQuestion
 * @description
 * @date 2020/3/1 17:41
 */
@Data
@Entity
@Table(name = "choice_question")
public class ChoiceQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String course;
    @ManyToOne
    private Question question;

    @ManyToOne
    private Knowledge knowledge;

    @ManyToOne
    private Teacher teacher;

    @NotNull
    private String stem;//题干
    private String option_1;
    private String option_2;
    private String option_3;
    private String option_4;
    @NotNull
    private String answer;
}
