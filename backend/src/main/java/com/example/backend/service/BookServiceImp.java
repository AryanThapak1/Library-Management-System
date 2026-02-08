package com.example.backend.service;

import com.example.backend.dto.BookDto;
import com.example.backend.mapper.BookMapper;
import com.example.backend.model.Book;
import com.example.backend.model.IssuedBook;
import com.example.backend.repository.BookRepository;
import com.example.backend.repository.IssuedBookRepository;
import com.example.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImp implements BookServiceInterface {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private IssuedBookRepository issuedBookRepository;

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> booksData= bookRepository.findAll();
        if (booksData.isEmpty()) return Collections.emptyList();
        List<BookDto> bookDtoData = booksData.stream().map(book -> BookMapper.toDto(book)).toList();
        return bookDtoData;
    }

    @Override
    public List<BookDto> getIssuedBooks(UUID studentId) {
        if (studentId == null) {
            return Collections.emptyList();
        }

        List<IssuedBook> issuedBooks = issuedBookRepository.findByStudentId_Id(studentId);
        if (issuedBooks.isEmpty()) return Collections.emptyList();

        return issuedBooks.stream()
                .map(IssuedBook::getBookId)
                .map(BookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto addBook(Book book) {
     if(book == null) return null;

     Book createdBook=bookRepository.save(book);
     return BookMapper.toDto(createdBook);
    }


}
