package com.libti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.libti.dtos.SubjectDto;
import com.libti.services.SubjectService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping("/subject")
    public ResponseEntity<String> createSubject(@RequestBody SubjectDto subjectDto) {
        subjectService.save(subjectDto);
        return ResponseEntity.ok("Subject created");
    }
    
}
