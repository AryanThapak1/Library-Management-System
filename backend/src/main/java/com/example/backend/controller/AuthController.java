package com.example.backend.controller;

import com.example.backend.dto.AdminDto;
import com.example.backend.model.Admin;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.StudentDto;
import com.example.backend.model.Student;
import com.example.backend.response.ApiResponse;
import com.example.backend.service.AuthServiceImp;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	AuthServiceImp authService;
	@PostMapping("/student/register")
	public ResponseEntity<ApiResponse<StudentDto>> registerStudent(@RequestBody Student student) {
		if(student==null) {
			return ResponseEntity.ofNullable(null);
		}
		
		StudentDto createdStudent=authService.registerStudent(student);
		return ResponseEntity.ok(new ApiResponse<StudentDto>(200,"Success",createdStudent));
		
	}

	@PostMapping("/admin/register")
	public ResponseEntity<ApiResponse<AdminDto>> registerLibrarian(@Valid @RequestBody Admin admin)
	{
		if(admin==null) return ResponseEntity.ofNullable(null);
		AdminDto createdAdmin=authService.registerLibrarian(admin);
		return ResponseEntity.ok(new ApiResponse<AdminDto>(200,"Success",createdAdmin));
	}
	
}
