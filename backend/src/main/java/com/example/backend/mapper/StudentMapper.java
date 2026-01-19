package com.example.backend.mapper;

import com.example.backend.dto.StudentDto;
import com.example.backend.model.Student;

public class StudentMapper {

	public static StudentDto toDto(Student student) {
		if (student == null) {
			throw new IllegalArgumentException("student must not be null");
		}

		return StudentDto.builder().id(student.getId()).name(student.getName()).email(student.getEmail())
				.password(student.getPassword()).branch(student.getBranch()).college(student.getCollege())
				.enrollementNumber(student.getEnrollementNumber()).build();
	}
}
