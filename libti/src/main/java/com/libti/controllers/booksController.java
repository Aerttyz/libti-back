package com.libti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.libti.dtos.booksDto;
import com.libti.models.bookModel;
import com.libti.services.booksService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class booksController {

    @Autowired
    booksService booksService;

    @PostMapping("/books")
    public ResponseEntity<String> createBook( @RequestBody booksDto booksDto) {
        
        booksService.save(booksDto);
        return ResponseEntity.ok("Book created");
    }

    @GetMapping("/books")
    public ResponseEntity<List<bookModel>> getBook() {
        return ResponseEntity.ok(booksService.getBook());
    }

    @GetMapping("/books/{title}")
    public ResponseEntity<List<bookModel>> getBookByTitle(@PathVariable String title) {
        return ResponseEntity.ok(booksService.getBookByTitle(title));
    }
}
