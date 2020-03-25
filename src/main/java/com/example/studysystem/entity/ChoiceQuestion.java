package com.example.studysystem.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Misaikun
 * @ClassName ChoiceQuestion
 * @description
 * @date 2020/3/1 17:41
 */

@Entity
@Table(name = "choice_question")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class ChoiceQuestion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String course;//科目

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties(ignoreUnknown = true,value = {"knowledge_grade"})
    @JoinColumn(name = "choicequestion_knowledge_id")
    @JsonBackReference(value ="knowledge" )
    private Knowledge knowledge;


    @JsonIgnoreProperties(ignoreUnknown = true,value = {"password","name"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "choicequestion_eacher_id")
    @JsonBackReference(value = "teacher")
    private Teacher teacher;

    @JsonIgnoreProperties
    @OneToMany(mappedBy = "choiceQuestion",fetch = FetchType.EAGER)
    private Set<ExaminationContent> examinationContents;


    @NotNull
    private String stem;//题干
    private String option_1;
    private String option_2;
    private String option_3;
    private String option_4;
    @NotNull
    private String answer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Knowledge getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(Knowledge knowledge) {
        this.knowledge = knowledge;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public String getOption_1() {
        return option_1;
    }

    public void setOption_1(String option_1) {
        this.option_1 = option_1;
    }

    public String getOption_2() {
        return option_2;
    }

    public void setOption_2(String option_2) {
        this.option_2 = option_2;
    }

    public String getOption_3() {
        return option_3;
    }

    public void setOption_3(String option_3) {
        this.option_3 = option_3;
    }

    public String getOption_4() {
        return option_4;
    }

    public void setOption_4(String option_4) {
        this.option_4 = option_4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Set<ExaminationContent> getExaminationContents() {
        return examinationContents;
    }

    public void setExaminationContents(Set<ExaminationContent> examinationContents) {
        this.examinationContents = examinationContents;
    }


    @Override
    public String toString() {
        return "ChoiceQuestion{" +
                "id=" + id +
                ", course='" + course + '\'' +
                ", stem='" + stem + '\'' +
                ", option_1='" + option_1 + '\'' +
                ", option_2='" + option_2 + '\'' +
                ", option_3='" + option_3 + '\'' +
                ", option_4='" + option_4 + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
