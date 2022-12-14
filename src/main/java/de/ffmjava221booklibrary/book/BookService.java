package de.ffmjava221booklibrary.book;

import de.ffmjava221booklibrary.book.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getBookList() {
        return bookRepo.getBookList();
    }

    public Book getBook(String isbn) {
        return bookRepo.getBook(isbn);
    }

    public Book addBook(Book book) {
        return bookRepo.addBook(book);
    }

    public Book deleteBook(String isbn) {
        return bookRepo.deleteBook(isbn);
    }
}
