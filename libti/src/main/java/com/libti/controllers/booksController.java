package com.libti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.libti.dtos.BooksDto;
import com.libti.models.BookModel;
import com.libti.services.BooksService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class BooksController {

    @Autowired
    BooksService booksService;

    @PostMapping("/uploud/books")
    public ResponseEntity<String> createBook( @RequestBody BooksDto booksDto) {
        
        booksService.save(booksDto);
        return ResponseEntity.ok("Book created");
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookModel>> getBook() {
        return ResponseEntity.ok(booksService.getBook());
    }

    @GetMapping("/books/{title}")
    public ResponseEntity<List<BookModel>> getBookByTitle(@PathVariable String title) {
        return ResponseEntity.ok(booksService.getBookByTitle(title));
    }
}
