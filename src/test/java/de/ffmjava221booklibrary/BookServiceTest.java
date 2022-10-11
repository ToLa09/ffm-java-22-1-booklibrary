package de.ffmjava221booklibrary;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {
    private BookRepo bookRepo = mock(BookRepo.class);
    private BookService bookService = new BookService(bookRepo);

   @Test
   void getBookListReturnsBooklist(){
       //given
        List<Book> testList = new ArrayList<>(List.of(
                new Book("1234","test","author")
        ));
       when(bookRepo.getBookList()).thenReturn(testList);
       //when
       List<Book> actual = bookService.getBookList();
       //then
       List<Book> expected = testList;
       assertEquals(expected,actual);
   }

   @Test
    void getBookReturnsBook(){
       //given
       String isbn = "1234";
       Book testBook = new Book("1234","testtitle","testauthor");
       when(bookRepo.getBook(isbn)).thenReturn(testBook);
       //when
       Book actual = bookService.getBook(isbn);
       //then
       Book expected = testBook;
       assertEquals(expected,actual);
   }

   @Test
    void addBook(){
       //given
       Book testBook = new Book("1234","testtitle","testauthor");
       when(bookRepo.addBook(testBook)).thenReturn(testBook);
       //when
       Book actual = bookService.addBook(testBook);
       //then
       Book expected = testBook;
       assertEquals(expected,actual);
   }
}