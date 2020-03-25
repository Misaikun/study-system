package com.example.studysystem.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Misaikun
 * @ClassName Message
 * @description 通知
 * @date 2020/3/11 1:34
 */
@Entity
@Data
@Table(name = "message")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String content;

//    @JsonIgnore
//    @JoinColumn(name = "teacher_id",insertable = true ,updatable = false)
//    @JsonBackReference
//    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    private Teacher teacher;

    @JsonIgnore
    @JoinColumn(name = "classinfo_id")
    @JsonBackReference(value = "classInfo")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private ClassInfo classInfo;
}
