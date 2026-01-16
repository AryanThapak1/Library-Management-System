package com.example.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data // Generates getters/setters
@Builder // Enables the builder pattern
@AllArgsConstructor // Required for @Builder
@NoArgsConstructor // Good practice for DTOs
public class StudenttDto {

    private UUID id;
    private String name;
    private String email;
    private String password;
}
