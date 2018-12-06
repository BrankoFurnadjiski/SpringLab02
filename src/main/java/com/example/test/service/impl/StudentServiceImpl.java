package com.example.test.service.impl;

import com.example.test.model.NewStudent;
import com.example.test.model.Student;
import com.example.test.model.StudyProgram;
import com.example.test.model.exceptions.*;
import com.example.test.persistance.StudentRepository;
import com.example.test.persistance.StudyProgramRepository;
import com.example.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudyProgramRepository studyProgramRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudyProgramRepository studyProgramRepository){
        this.studentRepository = studentRepository;
        this.studyProgramRepository = studyProgramRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public Student findStudent(String index) throws StudentNotFoundException {
        List<Student> student = studentRepository.findStudent(index);
        if(student.size() == 0) {
            throw new StudentNotFoundException(index);
        }
        return student.get(0);
    }

    @Override
    public List<Student> getStudentsByStudyProgram(Long id) {
        StudyProgram studyProgram = studyProgramRepository.findById(id).orElse(null);
        if(studyProgram == null){
            throw new StudyProgramNotFoundException(id);
        }
        return studentRepository.findStudentsByProgram(id);
    }

    @Override
    public Student addNewStudent(NewStudent newStudent) throws AddNewStudentException {
        String name = newStudent.name;
        String lastName = newStudent.lastName;
        String index = newStudent.index;
        String studyProgramName = newStudent.studyProgramName;
        if(name.compareTo("") == 0 ||
            lastName.compareTo("") == 0 ||
            index.compareTo("") == 0 ||
            studyProgramName.compareTo("") == 0){
            throw new AddNewStudentException();
        }
        Student student = studentRepository.existsByIndex(index);
        if(student != null){
            throw new StudentExistsException(index);
        }
        if(!index.matches("\\d{6}")){
            throw new AddNewStudentException();
        }
        StudyProgram studyProgram = studyProgramRepository.existsByName(studyProgramName);
        if(studyProgram == null){
            throw new StudyProgramExistsException(studyProgramName);
        }
        Student nStudent = new Student(index,name,lastName,studyProgram);
        return studentRepository.save(nStudent);
    }


    @Override
    public Student updateStudent(String index, NewStudent student) {
        String name =student.name;
        String lastName = student.lastName;
        String studyProgramName = student.studyProgramName;
        Student nStudent = studentRepository.existsByIndex(index);
        if(nStudent == null){
            throw new StudentNotFoundException(index);
        }
        if(studyProgramName != null) {
            StudyProgram studyProgram = studyProgramRepository.existsByName(studyProgramName);
            if(studyProgram == null){
                throw new StudyProgramExistsException(studyProgramName);
            }
            nStudent.setStudyProgram(studyProgram);
            //studentRepository.updateProgram(index, studyProgram);
        }
        if(name != null){
            nStudent.setName(name);
            //studentRepository.updateName(index,name);
        }
        if(lastName != null){
            nStudent.setLastName(lastName);
            //studentRepository.updateLastName(index,lastName);
        }
        return studentRepository.save(nStudent);
    }

    @Override
    public void deleteStudent(String index) {
        Student student = studentRepository.existsByIndex(index);
        if(student == null){
            throw new StudentNotFoundException(index);
        }
        studentRepository.delete(student);
    }

}
