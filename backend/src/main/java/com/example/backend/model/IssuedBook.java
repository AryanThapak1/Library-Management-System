package com.example.backend.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IssuedBook {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "Book_Id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_book_idy")
    )
    private Book bookId;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "student_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_student_id")
    )
    private Student studentId;

    @NotNull
    private java.time.LocalDate issuedDate;

    @NotNull
    private java.time.LocalDate returnDate;

}
