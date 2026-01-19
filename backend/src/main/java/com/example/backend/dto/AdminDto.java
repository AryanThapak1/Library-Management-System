package com.example.backend.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generates getters/setters
@Builder // Enables the builder pattern
@AllArgsConstructor // Required for @Builder
@NoArgsConstructor // Good practice for DTOs

public class AdminDto {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private String college;
    private String libraryId;
    private String branch;
}
