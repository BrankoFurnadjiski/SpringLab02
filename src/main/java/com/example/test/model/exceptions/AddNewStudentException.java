package com.example.test.model.exceptions;

public class AddNewStudentException extends RuntimeException{
    public AddNewStudentException(){
        super("Bad information sent to add new student");
    }
}
