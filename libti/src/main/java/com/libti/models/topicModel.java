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
@Table(name = "topic")
public class TopicModel {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    private UUID author;

    private int avaliations;

    private String[] comments;

    private UUID commentOwner;

    private int reports;
}
