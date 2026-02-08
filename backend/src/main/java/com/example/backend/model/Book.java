package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

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

    @NotBlank
    private String name;

    @NotBlank
    private String author;

    @NotNull
    @Positive
    private Integer ISBN;

    @NotNull
    @Positive
    private Float price;

    @NotNull
    @PositiveOrZero
    private Integer stock;


    @NotFound(action = NotFoundAction.IGNORE)
    @Size(min = 1, message = "description cannot be empty")
    private String description;

    @NotFound(action = NotFoundAction.IGNORE)
    @Size(min = 1, message = "ebookAddress cannot be empty")
    private String ebookAddress;

    @NotBlank
    private String coverImageAddress;

    @NotEmpty
    private List<@NotBlank String> category;

}
