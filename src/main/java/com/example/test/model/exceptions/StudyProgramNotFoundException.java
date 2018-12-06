package com.example.test.model.exceptions;

public class StudyProgramNotFoundException extends RuntimeException{
    public StudyProgramNotFoundException(Long id){
        super(String.format("Study Program with %s id was not found", id));
    }
}
