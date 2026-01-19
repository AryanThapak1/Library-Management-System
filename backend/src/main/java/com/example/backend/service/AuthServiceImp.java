package com.example.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.backend.dto.AuthDto;
import com.example.backend.model.Student;
import com.example.backend.repository.AdminRepository;
import com.example.backend.repository.StudentRepository;

@Service
public class AuthServiceImp implements AuthServiceInterface{
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

		
	@Override
	public StudentDto registerStudent(Student student) {
		if(studentRepository.findById(student.getId()).isPresent()) {
			return null;
		}
		student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
		Student createdStudent=studentRepository.save(student);
		
		return StudentDtoMapper.to
	}
}
