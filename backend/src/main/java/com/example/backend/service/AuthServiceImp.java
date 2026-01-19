package com.example.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.dto.AdminDto;
import com.example.backend.dto.AuthDto;
import com.example.backend.dto.StudentDto;
import com.example.backend.mapper.StudentMapper;
import com.example.backend.model.Student;
import com.example.backend.repository.AdminRepository;
import com.example.backend.repository.StudentRepository;

@Service
public class AuthServiceImp implements AuthServiceInterface{
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
//	@Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public StudentDto registerStudent(Student student) {
		if(studentRepository.findById(student.getId()).isPresent()) {
			return null;
		}
//		student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
		Student createdStudent=studentRepository.save(student);
		
		return StudentMapper.toDto(createdStudent);
	}

	@Override
	public AdminDto registerLibrarian() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthDto loginStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthDto loginLibrarian() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
