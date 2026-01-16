package com.example.backend.service;

import com.example.backend.dto.AuthDto;

public interface AuthServiceInterface {
	public AuthDto registerStudent();
	public AuthDto registerLibrarian();
	public AuthDto loginStudent();
	public AuthDto loginLibrarian();
}
