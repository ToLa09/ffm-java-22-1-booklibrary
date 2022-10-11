package de.ffmjava221booklibrary.book;

import de.ffmjava221booklibrary.book.model.Book;
import de.ffmjava221booklibrary.book.model.BookType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class BookRepo {
    private final List<Book> bookRepo= new ArrayList<>(List.of(
            new Book("1234","Krieg der Sterne", "author", BookType.EBOOK),
            new Book("5667","Buch zwei","author2",BookType.AUDIOBOOK)
    ));
    public List<Book> getBookList() {
        return bookRepo;
    }

    public Book getBook(String isbn) {
        for (Book book : bookRepo){
            if (book.isbn().equals(isbn)) {
                return book;
            }
        }
        throw new NoSuchElementException("Kein Buch mit dieser ISBN gefunden");
    }

    public Book addBook(Book book) {
        bookRepo.add(book);
        return book;
    }

    public Book deleteBook(String isbn) {
        for (Book book : bookRepo){
            if (book.isbn().equals(isbn)) {
                bookRepo.remove(book);
                return book;
            }
        }
        throw new NoSuchElementException("Kein Buch mit dieser ISBN gefunden");
    }
}
