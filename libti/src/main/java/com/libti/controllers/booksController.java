package com.libti.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.libti.dtos.booksDto;
import com.libti.models.bookModel;
import com.libti.repositories.booksRepository;
import com.libti.services.booksService;

@RestController
public class booksController {

    @Autowired
    booksService booksService;

    @PostMapping("/books")
    public ResponseEntity<String> createBook( @RequestBody booksDto booksDto) {
        
        booksService.save(booksDto);
        return ResponseEntity.ok("Book created");
    }

    
}
