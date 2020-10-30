package service;

import aspect.MarkedForLogging;
import model.Book;
import model.Borrowing;
import org.springframework.stereotype.Service;
import repository.BookRepository;

import java.util.HashMap;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printAllBooks() {
        HashMap<String, Book> books = bookRepository.getAll();
        books.entrySet().forEach(entry -> {
            System.out.println(entry.getValue());
        });
    }

    public Book getBook(String ISBN) {
        return bookRepository.getBook(ISBN);
    }

    public void addBook(String title, String author, String ISBN) {
        Book book = new Book(title, author, ISBN);
        bookRepository.addBook(book);
    }

    public void removeBook(String ISBN) {
        bookRepository.removeBook(ISBN);
    }

    public void borrowBook(String ISBN, String firstName, String lastName) throws Exception {
        Book book = bookRepository.getBook(ISBN);
        List<Borrowing> borrowings = book.getBorrowings();
        if (borrowings.size() > 0) {
            if (borrowings.get(borrowings.size() - 1).getReturnDate() == null) {
                throw new Exception("Book is already borrowed!");
            }
        }
        bookRepository.borrowBook(ISBN, firstName, lastName);
    }

    @MarkedForLogging
    public void returnBook(String ISBN) {
        bookRepository.returnBook(ISBN);
    }
}
