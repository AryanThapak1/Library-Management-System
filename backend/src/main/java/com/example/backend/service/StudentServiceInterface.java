package com.example.backend.service;

import com.example.backend.dto.StudentDto;

import java.util.List;

public interface StudentServiceInterface {
    List<StudentDto> getAllStudents();
}
