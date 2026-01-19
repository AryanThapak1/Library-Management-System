package com.example.backend.service;

import com.example.backend.dto.AdminDto;
import com.example.backend.dto.AuthDto;
import com.example.backend.dto.StudentDto;
import com.example.backend.model.Student;

public interface AuthServiceInterface {
	public StudentDto registerStudent(Student student);
	public AdminDto registerLibrarian();
	public AuthDto loginStudent();
	public AuthDto loginLibrarian();
	
}
