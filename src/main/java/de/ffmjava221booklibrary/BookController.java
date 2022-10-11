package de.ffmjava221booklibrary;

import de.ffmjava221booklibrary.book.BookService;
import de.ffmjava221booklibrary.book.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBookList(){
        return bookService.getBookList();
    }

    @GetMapping("{isbn}")
    public Book getBookList(@PathVariable String isbn){
        return bookService.getBook(isbn);
    }

    @PutMapping
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @DeleteMapping("{isbn}")
    public Book deleteBook(@PathVariable String isbn){
        return bookService.deleteBook(isbn);
    }
}
