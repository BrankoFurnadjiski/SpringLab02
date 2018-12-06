package com.example.test.model.exceptions;

public class StudyProgramExistsException extends RuntimeException{
    public StudyProgramExistsException(String name){
        super(String.format("Study Program with name %s doesn't exists!!", name));
    }
}
