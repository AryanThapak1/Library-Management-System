package com.example.backend.mapper;

import com.example.backend.dto.BookDto;
import com.example.backend.model.Book;

public class BookMapper {
    public static BookDto toDto(Book book)
    {
        if (book == null) {
            throw new IllegalArgumentException("book must not be null");
        }

        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .author(book.getAuthor())
                .isbn(book.getISBN())
                .price(book.getPrice())
                .stock(book.getStock())
                .description(book.getDescription())
                .ebookAddress(book.getEbookAddress())
                .coverImageAddress(book.getCoverImageAddress())
                .category(book.getCategory())
                .build();
    }
}
