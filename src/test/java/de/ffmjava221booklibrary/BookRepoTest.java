package de.ffmjava221booklibrary;

import de.ffmjava221booklibrary.book.model.Book;
import de.ffmjava221booklibrary.book.BookRepo;
import de.ffmjava221booklibrary.book.model.BookType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookRepoTest {
    private final BookRepo bookRepo = new BookRepo();

    @Test
    void getBookList() {
        //given

        //when
        List<Book> actual = bookRepo.getBookList();
        //then
        List<Book> expected = new ArrayList<>(List.of(
                new Book("1234","Krieg der Sterne", "author", BookType.EBOOK),
                new Book("5667","Buch zwei","author2",BookType.AUDIOBOOK)
        ));
        assertEquals(expected,actual);
    }

    @Test
    void getBook() {
        //given
        String isbn = "1234";
        //when
        Book actual = bookRepo.getBook(isbn);
        //then
        Book expected = new Book("1234","Krieg der Sterne", "author",BookType.EBOOK);
        assertEquals(expected,actual);
    }

    @Test
    void addBook() {
        //given
        Book testBook = new Book("1234","test title","test author",BookType.HARDCOVER);
        //when
        Book actual = bookRepo.addBook(testBook);
        //then
        Book expected = testBook;
        assertEquals(expected,actual);
    }

    @Test
    void deleteBook() {
        //given
        String isbn = "1234";
        //when
        Book actual = bookRepo.deleteBook(isbn);
        //then
        Book expected = new Book("1234","Krieg der Sterne", "author",BookType.EBOOK);
        assertEquals(expected,actual);
    }
}