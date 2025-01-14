package com.libti.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "books")
public class bookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @NotNull
    private String title;

    private String author;

    private String edition;

    private String publisher;

    private String isbn;

    private String yearPublication;

    @NotNull
    private String link;

    @NotNull
    @Column(columnDefinition = "BLOB")
    private byte[] cover;
}
