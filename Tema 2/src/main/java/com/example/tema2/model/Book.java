package com.example.tema2.model;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String            title;
    private String            author;
    private String            ISBN;
//    private List<Borrowing>   borrowings = new ArrayList<>();

    public Book(String title, String author, String ISBN) {
        this.title      = title;
        this.author     = author;
        this.ISBN       = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

//    public List<Borrowing> getBorrowings() {
//        return borrowings;
//    }

//    public void setBorrowings(List<Borrowing> borrowings) {
//        this.borrowings = borrowings;
//    }
//
//    public Borrowing getLastBorrowing() {
//        return this.borrowings.get(this.borrowings.size() - 1);
//    }

    @Override
    public String toString() {
        return
                "Title: '" + title + '\n' +
                "Author: '" + author + '\n' +
                "ISBN:'" + ISBN + '\n' + '\n';
    }
}
