package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class BookReview {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "posted_by",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_student_post")
    )
    private Student postedBy;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "posted_for",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_book_posted_by")
    )
    private Book postedFor;


    @NotNull
    private String review;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Student getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(Student postedBy) {
        this.postedBy = postedBy;
    }

    public Book getPostedFor() {
        return postedFor;
    }

    public void setPostedFor(Book postedFor) {
        this.postedFor = postedFor;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @NotNull
    private int rating;




}
