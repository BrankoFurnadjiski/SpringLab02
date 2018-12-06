package com.example.test.model.advice;

import com.example.test.model.exceptions.StudyProgramExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StudyProgramExistsAdvice {

    @ResponseBody
    @ExceptionHandler(StudyProgramExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String studyProgramExistsHandler(StudyProgramExistsException ex) { return ex.getMessage(); }
}
