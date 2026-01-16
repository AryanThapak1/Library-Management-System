package com.example.backend.controller;


import com.example.backend.service.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.backend.dto.StudenttDto;
import com.example.backend.response.ApiResponse;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentServiceInterface studentServiceInterface;
    @GetMapping("/student")
    public ResponseEntity<ApiResponse<List<StudenttDto>>> student() {
        List<StudenttDto> studentDetail = studentServiceInterface.getAllStudents();
        if(!ObjectUtils.isEmpty(studentDetail)) return ResponseEntity.ok(new ApiResponse<>(200, "Students fetched successfully", studentDetail));
        else{
            return ResponseEntity.ok(new ApiResponse<>(500, "Students not found", null));
        }
    }

}
