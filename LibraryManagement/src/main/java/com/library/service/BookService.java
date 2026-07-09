package com.library.service;

import com.library.repository.BookRepository;

/**
 * BookService - Business Logic Layer
 * 
 * This class represents the service layer in the application.
 * It contains the business logic and orchestrates operations between
 * the presentation layer and the data access layer (repository).
 * 
 * Dependency Injection:
 * - BookRepository is injected via constructor injection.
 * - This allows Spring to manage the lifecycle of the BookRepository bean
 *   and automatically inject it when creating a BookService instance.
 * 
 * Benefits of Constructor Injection:
 * - Makes dependencies explicit and immutable
 * - Ensures that BookService cannot be instantiated without its dependency
 * - Promotes loose coupling between BookService and BookRepository
 */
public class BookService {

    // Private field to hold the BookRepository dependency
    private BookRepository bookRepository;

    /**
     * Constructor for constructor-based dependency injection.
     * 
     * Spring's IoC container will call this constructor and pass
     * the BookRepository bean as a parameter during instantiation.
     * 
     * @param bookRepository The BookRepository instance injected by Spring
     */
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("[BookService] Constructor: BookRepository injected successfully.");
    }

    /**
     * Displays book details by delegating to the repository layer.
     * 
     * This method represents the business logic that calls
     * the repository to retrieve and display book information.
     */
    public void displayBookDetails() {
        System.out.println("\n========================================");
        System.out.println("[BookService] Displaying Book Details:");
        System.out.println("========================================");
        String details = bookRepository.getBookDetails();
        System.out.println(details);
        System.out.println("========================================\n");
    }
}
