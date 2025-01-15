package com.libti.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libti.models.subjectModel;

@Repository
public interface SubjectRepository extends JpaRepository<subjectModel, UUID> {

}
