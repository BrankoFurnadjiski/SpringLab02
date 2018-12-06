package com.example.test.model.advice;

import com.example.test.model.exceptions.AddNewStudyProgramException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AddNewStudyProgramAdvice {

    @ResponseBody
    @ExceptionHandler(AddNewStudyProgramException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String addNewStudyProgramHandler(AddNewStudyProgramException ex){ return ex.getMessage(); }
}
