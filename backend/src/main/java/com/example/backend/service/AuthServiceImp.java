package com.example.backend.service;

import com.example.backend.mapper.AdminMapper;
import com.example.backend.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.backend.dto.AdminDto;
import com.example.backend.dto.AuthDto;
import com.example.backend.dto.StudentDto;
import com.example.backend.mapper.AuthMapper;
import com.example.backend.mapper.StudentMapper;
import com.example.backend.model.Auth;
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
	JwtService jwtService;
	
    BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();

		
	@Override
	public StudentDto registerStudent(Student student) {
		 if (studentRepository.existsByEmail(student.getEmail())) {
		        throw new RuntimeException("Student already exists with this email");
		    }
		 if (studentRepository.existsByEnrollementNumber(student.getEnrollementNumber())) {
			    throw new RuntimeException("Enrollment number already registered");
			}
		student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
		Student createdStudent=studentRepository.save(student);
		
		return StudentMapper.toDto(createdStudent);
	}


	@Override
	public AdminDto registerLibrarian(Admin admin) {
		// TODO Auto-generated method stub
	if(adminRepository.existsByEmail(admin.getEmail()))
	{
		throw new RuntimeException("Admin already exists with this email");
	}
	if(adminRepository.existsByLibraryId(admin.getLibraryId()))
	{
		throw new RuntimeException("Librarian with this id already present");
	}

	admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
	Admin createdAdmin=adminRepository.save(admin);

	return AdminMapper.toDto(createdAdmin);

	}



	@Override
	public AuthDto loginStudent(Auth credentials) {
		// TODO Auto-generated method stub
		Student student=studentRepository.findByEmail(credentials.getEmail());
		if(!bCryptPasswordEncoder.matches(credentials.getPassword(), student.getPassword())) {
			throw new RuntimeException("Invalid email or password");
		}
		
		String accessToken=jwtService.generateAccessToken(student.getId(), student.getEmail(), "Student");
		String refreshToken=jwtService.generateRefreshToken(student.getId(), student.getEmail(), "Student");
		return AuthMapper.toDto(accessToken, refreshToken);
	}


	@Override
	public AuthDto loginLibrarian() {
		// TODO Auto-generated method stub
		return null;
	}
}
