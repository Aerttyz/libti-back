package com.libti.services;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libti.dtos.SubjectDto;
import com.libti.models.subjectModel;
import com.libti.repositories.SubjectRepository;

import jakarta.transaction.Transactional;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository SubjectRepository;

    @Transactional
    public void save(SubjectDto SubjectDto) {
        try {
           subjectModel subjectModel = new subjectModel();
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
}
