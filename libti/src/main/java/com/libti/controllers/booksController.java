package com.libti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.libti.dtos.booksDto;
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
