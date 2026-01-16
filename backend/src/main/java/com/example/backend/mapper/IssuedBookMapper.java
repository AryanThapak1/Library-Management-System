package com.example.backend.mapper;

import com.example.backend.dto.IssuedBookDto;
import com.example.backend.model.IssuedBook;

public class IssuedBookMapper {

    public static IssuedBookDto toDto(IssuedBook issuedBook) {
        if (issuedBook == null) {
            throw new IllegalArgumentException("issuedBook must not be null");
        }

        return IssuedBookDto.builder()
                .id(issuedBook.getId())
                .bookId(issuedBook.getBookId())
                .studentId(issuedBook.getStudentId())
                .issuedDate(issuedBook.getIssuedDate())
                .returnDate(issuedBook.getReturnDate())
                .build();
    }
}
