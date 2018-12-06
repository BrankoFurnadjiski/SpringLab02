package com.example.test;

import com.example.test.model.Student;
import com.example.test.model.StudyProgram;
import com.example.test.persistance.StudentRepository;
import com.example.test.persistance.StudyProgramRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DatabaseConfiguration {

    @Bean
    CommandLineRunner initDatabase(StudentRepository studentRepository, StudyProgramRepository studyProgramRepository){
       return args -> {
           StudyProgram sp1 = new StudyProgram("Computer science");
           StudyProgram sp2 = new StudyProgram("Economics");
           StudyProgram sp3 = new StudyProgram("Philosophy");
           StudyProgram sp4 = new StudyProgram("Dentistry");
           StudyProgram sp5 = new StudyProgram("Business and Management");
           StudyProgram sp6 = new StudyProgram("Law");

           List<StudyProgram> studyPrograms = Arrays.asList(sp1, sp2, sp3, sp4, sp5, sp6);
           studyPrograms.forEach(studyProgramRepository::save);

           Student s1 = new Student("151025","John", "Doe", sp1);
           Student s2 = new Student("151026","Robert", "Jones", sp2);
           Student s3 = new Student("151027","Will", "Smith", sp3);
           Student s4 = new Student("151028","Trevor", "Davis", sp4);
           Student s5 = new Student("151052","Thomas", "Rogers", sp5);
           Student s6 = new Student("151029","Luca", "Rivera", sp6);

           List<Student> students = Arrays.asList(s1, s2, s3, s4, s5, s6);
           students.forEach(studentRepository::save);
       };
    }
}
