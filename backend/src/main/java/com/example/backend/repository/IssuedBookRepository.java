package com.example.backend.repository;

import com.example.backend.model.IssuedBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IssuedBookRepository extends JpaRepository<IssuedBook, UUID> {
}
