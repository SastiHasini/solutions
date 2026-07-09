package com.bookstore.service;

import com.bookstore.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBook() {
        System.out.println("BookService: Displaying book details...");
        bookRepository.getBookDetails();
    }
}