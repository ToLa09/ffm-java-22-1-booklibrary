package de.ffmjava221booklibrary;

public record Book(
        String isbn,
        String title,
        String author,
        BookType type
) {
}
