package com.example.backend.controller;
import com.example.backend.dto.BookDto;
import com.example.backend.service.StudentServiceInterface;
import com.example.backend.service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.backend.dto.StudenttDto;
import com.example.backend.response.ApiResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller("/student")
public class StudentController {

    @Autowired
    private StudentServiceInterface studentServiceInterface;
    @Autowired
    private BookServiceInterface bookServiceInterface;


    @GetMapping("details")
    public ResponseEntity<ApiResponse<List<StudenttDto>>> studentDetails() {
        List<StudenttDto> studentDetail = studentServiceInterface.getAllStudents();
        if(!ObjectUtils.isEmpty(studentDetail)) return ResponseEntity.ok(new ApiResponse<>(200, "Students fetched successfully", studentDetail));
        else{
            return ResponseEntity.ok(new ApiResponse<>(500, "Students not found", null));
        }
    }

//    @GetMapping("/book/details")
//    public ResponseEntity<ApiResponse<BookDto>> bookDetails()
//    {
//        List <BookDto> boookDetail = bookServiceInterface.getAllBooks();
//        if(!ObjectUtils.isEmpty(boookDetail)) {
//            return ResponseEntity.ok(new ApiResponse<>(200,"Book Detail fetched successfully",boookDetail));
//        }
//        else {
//            return ResponseEntity.ok(new ApiResponse<>(500,"Book Detail Not Found",null));
//        }
//    }


    @GetMapping("/issuedBooks/{studentId}")
    public ResponseEntity<ApiResponse<List<BookDto>>> studentIssuedBooks(
            @PathVariable UUID studentId) {

        List<BookDto> issuedBooks = bookServiceInterface.getIssuedBooks(studentId);

        if (issuedBooks.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(404, "No issued books found", null));
        }

        return ResponseEntity.ok(
                new ApiResponse<>(200, "Issued books fetched successfully", issuedBooks)
        );
    }


}
