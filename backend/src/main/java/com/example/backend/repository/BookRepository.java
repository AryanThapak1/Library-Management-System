package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend.model.Book;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
