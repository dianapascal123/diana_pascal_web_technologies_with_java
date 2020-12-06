package com.example.tema2.service;


import com.example.tema2.model.Book;
import com.example.tema2.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public HashMap<String, Book> printAllBooks() {
        HashMap<String, Book> books = bookRepository.getAll();
        return books;
    }

    public void addBook(Book book) throws Exception {
        if (bookRepository.getBook(book.getISBN()) != null)
            throw new Exception("Book already exists");
        Book newBook = new Book(book.getTitle(), book.getAuthor(), book.getISBN(), false);
        bookRepository.addBook(newBook);
    }

    public void removeBook(Book book) throws Exception {
        if (bookRepository.getBook(book.getISBN()) == null) {
            throw new Exception("Book does not exists");
        }
        bookRepository.removeBook(book.getISBN());
    }

    public void borrowBook(String ISBN) throws Exception {
        bookRepository.borrowBook(ISBN);
    }

    public void returnBook(String ISBN) {
        bookRepository.returnBook(ISBN);
    }
}
