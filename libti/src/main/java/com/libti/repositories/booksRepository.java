package com.libti.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libti.models.bookModel;

@Repository
public interface booksRepository extends JpaRepository<bookModel, UUID> {
    
    List<bookModel> findByTitleContainingIgnoreCase(String title);

}
