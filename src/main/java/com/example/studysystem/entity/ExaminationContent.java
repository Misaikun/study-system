package com.example.studysystem.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Misaikun
 * @ClassName ExaminationContent
 * @description 试卷与题目连接
 * @date 2020/3/18 23:36
 */

@Entity
@Data
@Table(name = "examinationContent")
@JsonIdentityInfo(generator =ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class ExaminationContent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "examination_id" )
    @JsonBackReference(value = "examination")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties(ignoreUnknown = true,value={"classInfo","createTime","stareTime","endTime"})
    private Examination examination;

    @JoinColumn(name = "choicequestion_id" )
    @JsonBackReference(value = "choiceQuestion")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties(ignoreUnknown = true,value = {"knowledge","teacher"})
    private ChoiceQuestion choiceQuestion;


    @JsonIgnoreProperties
    @OneToMany(mappedBy = "examinationContent",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Answer> answers;
}
