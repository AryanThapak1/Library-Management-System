package com.example.backend.mapper;

import com.example.backend.dto.AuthDto;

public class AuthMapper {
	public static AuthDto toDto(String accessToken,String refreshToken) {
		
		return AuthDto.builder().accessToken(accessToken).refreshToken(refreshToken).build();
	}
}
