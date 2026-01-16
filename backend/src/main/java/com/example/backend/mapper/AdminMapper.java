package com.example.backend.mapper;

import com.example.backend.dto.AdminResponseDto;
import com.example.backend.model.Admin;

public class AdminMapper {

    public static AdminResponseDto toDto(Admin admin) {
        if (admin == null) {
            throw new IllegalArgumentException("admin must not be null");
        }

        return AdminResponseDto.builder()
                .id(admin.getId())
                .name(admin.getName())
                .email(admin.getEmail())
                .password(admin.getPassword())
                .build();
    }
}
