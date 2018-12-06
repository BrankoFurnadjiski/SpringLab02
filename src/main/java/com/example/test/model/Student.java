package com.example.test.model;


import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Student {

    private @Id
    String index;

    private String name;

    private String lastName;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private StudyProgram studyProgram;

    protected Student() {}

    public Student(String index, String name, String lastName, StudyProgram studyProgram){
        this.index = index;
        this.name = name;
        this.lastName = lastName;
        this.studyProgram = studyProgram;
    }
}
