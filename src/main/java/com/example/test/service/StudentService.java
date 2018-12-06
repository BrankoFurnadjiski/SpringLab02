package com.example.test.service;

import com.example.test.model.NewStudent;
import com.example.test.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student findStudent(String index);

    List<Student> getStudentsByStudyProgram(Long id);

    Student addNewStudent(NewStudent newStudent);

    Student updateStudent(String index, NewStudent student);

    void deleteStudent(String index);
}
