package com.libti.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class booksController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, teste!";
    }
}
