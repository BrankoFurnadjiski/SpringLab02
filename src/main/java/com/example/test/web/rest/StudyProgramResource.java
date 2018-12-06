package com.example.test.web.rest;

import com.example.test.model.NewStudyProgram;
import com.example.test.model.StudyProgram;
import com.example.test.service.impl.StudyProgramServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class StudyProgramResource {

    private final StudyProgramServiceImpl studyProgramServiceImpl;

    @Autowired
    public StudyProgramResource(StudyProgramServiceImpl studyProgramServiceImpl){
        this.studyProgramServiceImpl = studyProgramServiceImpl;
    }

    @GetMapping("/study_programs")
    public List<StudyProgram> getAllStudyPrograms() {
        return studyProgramServiceImpl.getAllStudyPrograms();
    }

    @PostMapping(value = "/study_programs",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addNewStudyProgram(@RequestBody NewStudyProgram studyProgramName){
        studyProgramServiceImpl.addNewStudyProgram(studyProgramName);
        getAllStudyPrograms();
    }

    @DeleteMapping(value="/study_programs/{id}")
    public void deleteStudyProgram(@PathVariable Long id){
        studyProgramServiceImpl.deleteStudyProgram(id);
        getAllStudyPrograms();
    }
}
