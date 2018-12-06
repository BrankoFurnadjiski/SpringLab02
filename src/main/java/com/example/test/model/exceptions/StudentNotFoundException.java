package com.example.test.model.exceptions;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String index){
        super(String.format("Student with id %s doesn't exists.", index));
    }

}
