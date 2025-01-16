package com.libti.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libti.models.SubjectModel;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectModel, UUID> {
    List<SubjectModel> findByNameContainingIgnoreCase(String name);
}
