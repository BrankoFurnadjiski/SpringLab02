package com.example.test.model.advice;

import com.example.test.model.exceptions.AddNewStudentException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AddNewStudentAdvice {

    @ResponseBody
    @ExceptionHandler(AddNewStudentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String addNewStudnetHandler(AddNewStudentException ex){
        return ex.getMessage();
    }
}
