package com.example.backend.controller;


import com.example.backend.dto.BookDto;
import com.example.backend.model.Book;
import com.example.backend.response.ApiResponse;
import com.example.backend.service.BookServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookServiceInterface bookServiceInterface;

    @GetMapping("/details")
    public ResponseEntity<ApiResponse<?>> bookDetails()
    {
        List<BookDto> boookDetail = bookServiceInterface.getAllBooks();
        if(!ObjectUtils.isEmpty(boookDetail)) {
            return ResponseEntity.ok(new ApiResponse<>(200,"Book Detail fetched successfully",boookDetail));
        }
        else {
            return ResponseEntity.ok(new ApiResponse<>(500,"Book Detail Not Found",null));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<?>> bookAddition(@Valid @RequestBody Book book)
    {

        BookDto createdBook = bookServiceInterface.addBook(book);
        if(createdBook!= null) return ResponseEntity.ok(new ApiResponse<>(200,"Book Added Successfully",createdBook));

        return ResponseEntity.ok(new ApiResponse<>(500,"Book Detail Not Found",null));

    }
}
