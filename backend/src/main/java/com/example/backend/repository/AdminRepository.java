package com.example.backend.repository;

import com.example.backend.model.Admin;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {
    boolean existsByEmail(String email);

    boolean existsByLibraryId(String libraryId);
}
