package com.example.backend.service;

import com.example.backend.dto.StudenttDto;
import com.example.backend.mapper.StudentMapper;
import com.example.backend.model.Student;
import com.example.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImp implements StudentServiceInterface {
@Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudenttDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        if(students.isEmpty()){
            return null;
        }
        List<StudenttDto> studentDtos = students.stream().map(student -> StudentMapper.toDto(student)).toList();
        if(studentDtos.isEmpty()) return null;
        return studentDtos;
    }
}
