package com.libti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.libti.dtos.SubjectDto;
import com.libti.models.SubjectModel;
import com.libti.services.SubjectService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping("/uploud/subject")
    public ResponseEntity<String> createSubject(@RequestBody SubjectDto subjectDto) {
        subjectService.save(subjectDto);
        return ResponseEntity.ok("Subject created");
    }

    @GetMapping("/subject")
    public ResponseEntity<List<SubjectModel>> getSubject() {
        return ResponseEntity.ok(subjectService.getSubject());
    }

    @GetMapping("/subject/{name}")
    public ResponseEntity<List<SubjectModel>> getSubjectByName(@PathVariable String name) {
        return ResponseEntity.ok(subjectService.getSubjectByName(name));
    }
}
