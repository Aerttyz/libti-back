package com.libti.services;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libti.dtos.SubjectDto;
import com.libti.models.SubjectModel;
import com.libti.repositories.SubjectRepository;

import jakarta.transaction.Transactional;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository SubjectRepository;

    @Transactional
    public void save(SubjectDto SubjectDto) {
        try {
           SubjectModel subjectModel = new SubjectModel();
            try {
                String sanitizedInput = new String(SubjectDto.getFile()).replaceAll("\\s+", "");
                byte[] decodedCover = Base64.getDecoder().decode(sanitizedInput);
                subjectModel.setFile(decodedCover);
            } catch (Exception e) {
                e.printStackTrace();
            }
            subjectModel.setCode(SubjectDto.getCode());
            subjectModel.setName(SubjectDto.getName());
            subjectModel.setSemester(SubjectDto.getSemester());
            subjectModel.setTeacher(SubjectDto.getTeacher());
            subjectModel.setFileLink(SubjectDto.getFileLink());
            SubjectRepository.save(subjectModel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<SubjectModel> getSubject() {
        try {
            List<SubjectModel> subjects = SubjectRepository.findAll();
            return subjects;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SubjectModel> getSubjectByName(String name) {
        try {
            List<SubjectModel> subjects = SubjectRepository.findByNameContainingIgnoreCase(name);
            return subjects;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
