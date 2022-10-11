package de.ffmjava221booklibrary.book.model;

public record Book(
        String isbn,
        String title,
        String author,
        BookType type
) {
}
