package com.example.test.model.advice;

import com.example.test.model.exceptions.StudentExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StudentExistsAdvice {

    @ResponseBody
    @ExceptionHandler(StudentExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String studentExistsHandler(StudentExistsException ex) { return ex.getMessage(); }
}
