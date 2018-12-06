package com.example.test.service.impl;

import com.example.test.model.NewStudyProgram;
import com.example.test.model.StudyProgram;
import com.example.test.model.exceptions.AddNewStudyProgramException;
import com.example.test.model.exceptions.StudyProgramNotFoundException;
import com.example.test.persistance.StudyProgramRepository;
import com.example.test.service.StudyProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyProgramServiceImpl implements StudyProgramService {

    private final StudyProgramRepository studyProgramRepository;

    @Autowired
    public StudyProgramServiceImpl(StudyProgramRepository studyProgramRepository){
        this.studyProgramRepository = studyProgramRepository;
    }

    @Override
    public List<StudyProgram> getAllStudyPrograms() {
        return studyProgramRepository.getAllStudyPrograms();
    }

    @Override
    public void addNewStudyProgram(NewStudyProgram studyProgramName) {
        String name = studyProgramName.studyProgramName;
        if(name == null){
            throw new AddNewStudyProgramException();
        }
        StudyProgram program = new StudyProgram(name);
        studyProgramRepository.save(program);
    }

    @Override
    public void deleteStudyProgram(Long id) {
        StudyProgram program = studyProgramRepository.findById(id).orElse(null);
        if(program == null) {
            throw new StudyProgramNotFoundException(id);
        }
        studyProgramRepository.deleteById(program.getId());
    }

}
