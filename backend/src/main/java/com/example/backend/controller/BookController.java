package com.example.backend.controller;


import com.example.backend.dto.BookDto;
import com.example.backend.response.ApiResponse;
import com.example.backend.service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookServiceInterface bookServiceInterface;

    @GetMapping("/book/details")
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
}
