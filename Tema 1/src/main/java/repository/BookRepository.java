package repository;

import model.Book;
import model.Borrowing;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;


@Repository
public class BookRepository {
    private final Book book1 = new Book("Harry Potter and the Sorcerer’s Stone", "J.K. Rowling", "9781524721251");
    private final Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", "9781524721252");
    private final Book book3 = new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "9781524721253");

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

    public void borrowBook(String ISBN, String firstName, String lastName) {
        Book book = books.get(ISBN);
        List<Borrowing> borrowings = book.getBorrowings();
        LocalDate date = LocalDate.now();
        borrowings.add(new Borrowing(firstName, lastName, date, date.plusDays(14)));
    }

    public void returnBook(String ISBN) {
        Book book = books.get(ISBN);
        List<Borrowing> borrowings = book.getBorrowings();
        borrowings.get(borrowings.size() - 1).setReturnDate(LocalDate.now());
    }
}
