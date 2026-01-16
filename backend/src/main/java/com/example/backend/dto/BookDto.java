package com.example.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.UUID;

@Data // Generates getters/setters
@Builder // Enables the builder pattern
@AllArgsConstructor // Required for @Builder
@NoArgsConstructor // Good practice for DTOs
public class BookDto {


    private UUID id;

    private String name;

    private String author;

    private int isbn;

    private Float price;


    private int stock;

    private String description;

    private String ebookAddress;

    private String coverImageAddress;

    private List<String> category;
}
