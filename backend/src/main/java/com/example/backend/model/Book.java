package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String author;

    @NotNull
    private int ISBN;

    @NotNull
    private Float price;

    @NotNull
    private int stock;


    @NotFound(action = NotFoundAction.IGNORE)
    private String description;

    @NotFound(action = NotFoundAction.IGNORE)
    private String ebookAddress;

    @NotNull
    private String coverImageAddress;

    @NotNull
    private List<String> category;

}
