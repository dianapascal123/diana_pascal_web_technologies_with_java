package main;

import config.ProjectConfig;
import model.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.BookService;

public class Application {
    public static void main(String[] args) throws Exception{
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        BookService bookService = context.getBean(BookService.class);

        System.out.println("Welcome to the library. This is the list of our books: \n");
        bookService.printAllBooks();

        bookService.addBook("Harry Potter and the Goblet of Fire", "J.K.Rowling", "9781524721254");
        System.out.println("Book list after adding the new one:\n");
        bookService.printAllBooks();

        Book book = bookService.getBook("9781524721254");
        bookService.borrowBook("9781524721254", "Diana", "Pascal");

        System.out.println("Book was borrowed between " + book.getLastBorrowing().getStartDate() + " and " + book.getLastBorrowing().getEndDate());

        System.out.println("Borrowing same book again\n");
        //comment this line to see the error occurring when trying to borrow a book that is not available
        bookService.returnBook("9781524721254");
        bookService.borrowBook("9781524721254", "Diana", "Pascal");

        bookService.removeBook("9781524721254");
        System.out.println("Book list after removing one:\n");
        bookService.printAllBooks();
    }
}
