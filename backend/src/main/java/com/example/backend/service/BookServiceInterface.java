package com.example.backend.service;

import com.example.backend.dto.BookDto;
import com.example.backend.model.Book;

import java.util.List;
import java.util.UUID;

public interface BookServiceInterface {
    List<BookDto> getAllBooks();
    List<BookDto> getIssuedBooks(UUID studentId);
    BookDto addBook(Book book);
}
