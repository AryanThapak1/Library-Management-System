package com.example.backend.service;

import com.example.backend.dto.StudenttDto;
import com.example.backend.model.Student;

import java.util.List;

public interface StudentServiceInterface {
    List<StudenttDto> getAllStudents();
}
