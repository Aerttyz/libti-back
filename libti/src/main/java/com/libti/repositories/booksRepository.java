package com.libti.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libti.models.BookModel;

@Repository
public interface BooksRepository extends JpaRepository<BookModel, UUID> {
    
    List<BookModel> findByTitleContainingIgnoreCase(String title);

}
