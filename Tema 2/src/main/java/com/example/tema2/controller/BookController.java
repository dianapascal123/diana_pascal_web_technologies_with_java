package com.example.tema2.controller;

import com.example.tema2.model.Book;
import com.example.tema2.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public Map<String, Book> printAllBooks() {
        return bookService.printAllBooks();
    }

    @PostMapping("/borrow")
    public ResponseEntity<String> borrowBook(@RequestBody Book book) {
        try {
            bookService.borrowBook(book.getISBN());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred: " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Book was borrowed");
    }

    @PostMapping("/return")
    public ResponseEntity<String> returnBook(@RequestBody Book book) {
        try {
            bookService.returnBook(book.getISBN());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred: " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Book was returned");
    }

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        try {
            bookService.addBook(book);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred: " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Book wad added");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBook(@RequestBody Book book) {
        try {
            bookService.removeBook(book);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred: " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Book wad deleted");
    }
}
