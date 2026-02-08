package com.example.backend.mapper;

import com.example.backend.dto.AdminDto;
import com.example.backend.model.Admin;

public class AdminMapper {

    public static AdminDto toDto(Admin admin) {
        if (admin == null) {
            throw new IllegalArgumentException("admin must not be null");
        }

        return AdminDto.builder()
                .id(admin.getId())
                .name(admin.getName())
                .email(admin.getEmail())
                .password(admin.getPassword())
                .college(admin.getCollege())
                .libraryId(admin.getLibraryId())
                .branch(admin.getBranch())
                .build();
    }
}
