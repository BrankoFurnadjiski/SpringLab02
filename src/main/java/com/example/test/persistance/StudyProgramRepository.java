package com.example.test.persistance;

import com.example.test.model.StudyProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudyProgramRepository extends JpaRepository<StudyProgram, Long> {

    @Query("SELECT program FROM StudyProgram program WHERE program.name=?1")
    StudyProgram existsByName(String name);

    @Query("SELECT program FROM StudyProgram program")
    List<StudyProgram> getAllStudyPrograms();
}
