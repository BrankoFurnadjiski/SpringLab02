package com.example.test.model.exceptions;

public class StudentExistsException extends RuntimeException{
    public StudentExistsException(String index){
        super(String.format("Student with index %s exists!!", index));
    }
}
