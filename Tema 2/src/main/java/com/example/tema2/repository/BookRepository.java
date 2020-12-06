package com.example.tema2.repository;

import com.example.tema2.model.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;


@Repository
public class BookRepository {
    private final Book book1 = new Book("Harry Potter and the Sorcerer’s Stone", "J.K. Rowling", "9781524721251", false);
    private final Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", "9781524721252", false);
    private final Book book3 = new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "9781524721253", false);

    private HashMap<String, Book> books = new HashMap<String, Book>() {{
        put("9781524721251", book1);
        put("9781524721252", book2);
        put("9781524721253", book3);
    }};

    public Book getBook(String ISBN) {
        return books.get(ISBN);
    }

    public HashMap<String, Book> getAll() {
        return books;
    }

    public void addBook(Book book) {
        books.put(book.getISBN(), book);
    }

    public void removeBook(String ISBN) {
        books.remove(ISBN);
    }

    public void borrowBook(String ISBN) {
        Book book = books.get(ISBN);
        book.setIsBorrowed(true);
    }

    public void returnBook(String ISBN) {
        Book book = books.get(ISBN);
        book.setIsBorrowed(false);
    }
}
