package com.example.test.service;

import com.example.test.model.NewStudyProgram;
import com.example.test.model.StudyProgram;

import java.util.List;

public interface StudyProgramService {

    List<StudyProgram> getAllStudyPrograms();

    void addNewStudyProgram(NewStudyProgram studyProgramName);

    void deleteStudyProgram(Long id);
}
