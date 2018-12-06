package com.example.test.model.exceptions;

public class AddNewStudyProgramException extends  RuntimeException{
    public AddNewStudyProgramException(){
        super("No name provided for study program");
    }
}
