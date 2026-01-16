package com.example.backend.mapper;

import com.example.backend.dto.StudenttDto;
import com.example.backend.model.Student;

public class StudentMapper {

    public static StudenttDto toDto(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("student must not be null");
        }

        return StudenttDto.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .password(student.getPassword())
                .build();
    }
}
