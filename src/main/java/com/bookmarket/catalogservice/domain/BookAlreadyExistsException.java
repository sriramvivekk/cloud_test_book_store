package com.bookmarket.catalogservice.domain;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(String isbn) {
        super("A book with ISBN " + isbn + " is already exists.");
    }
}
