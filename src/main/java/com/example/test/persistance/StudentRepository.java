package com.example.test.persistance;

import com.example.test.model.Student;
import com.example.test.model.StudyProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT student.index, student.name, student.lastName FROM Student student")
    List<Student> getAllStudents();

    @Query("SELECT student FROM Student student WHERE student.index=?1")
    List<Student> findStudent(String index);

    @Query("SELECT student FROM Student student WHERE student.studyProgram.id=?1")
    List<Student> findStudentsByProgram(Long id);

    @Query("SELECT student FROM Student student WHERE student.id=?1")
    Student existsByIndex(String index);

    @Modifying
    @Query("UPDATE Student student SET student.studyProgram=?1 WHERE student.index=?2")
    void updateProgram(String index, StudyProgram program);

    @Modifying
    @Query("UPDATE Student student SET student.name=?1 WHERE student.index=?2")
    void updateName(String index, String name);

    @Modifying
    @Query("UPDATE Student student SET student.lastName=?1 WHERE student.index=?2")
    void updateLastName(String index, String lastName);

}
