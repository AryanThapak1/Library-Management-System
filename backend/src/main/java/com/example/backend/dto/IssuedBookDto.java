package com.example.backend.dto;


import com.example.backend.model.Book;
import com.example.backend.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data // Generates getters/setters
@Builder // Enables the builder pattern
@AllArgsConstructor // Required for @Builder
@NoArgsConstructor // Good practice for DTOs
public class IssuedBookDto {
    private UUID id;
    private Book bookId;
    private Student studentId;
    private LocalDate issuedDate;
    private LocalDate returnDate;
}
