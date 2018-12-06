package com.example.test.web.rest;

import com.example.test.model.NewStudent;
import com.example.test.model.Student;
import com.example.test.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentResource {

    private final StudentServiceImpl studentServiceImpl;

    @Autowired
    public StudentResource(StudentServiceImpl studentServiceImpl){
        this.studentServiceImpl = studentServiceImpl;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentServiceImpl.getAllStudents();
    }

    @GetMapping("/students/{index}")
    public Student getStudent(@PathVariable String index){
        return studentServiceImpl.findStudent(index);
    }

    @GetMapping("/students/by_study_program/{id}")
    public List<Student> getStudentByProgram(@PathVariable Long id){
        return studentServiceImpl.getStudentsByStudyProgram(id);
    }

    @PostMapping(value = "/students", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewStudent(@RequestBody NewStudent newStudent, HttpServletResponse response) {
        Student student =  studentServiceImpl.addNewStudent(newStudent);
        getStudent(student.getIndex());
    }

    @PatchMapping(value = "/students/{index}")
    public void updateStudent(@RequestBody NewStudent student,
                              @PathVariable String index){
        Student nStudent =  studentServiceImpl.updateStudent(index, student);
        getStudent(nStudent.getIndex());
    }

    @DeleteMapping(value = "/students/{index}")
    public void deleteStudent(@PathVariable String index){
        studentServiceImpl.deleteStudent(index);
        getAllStudents();
    }

}
