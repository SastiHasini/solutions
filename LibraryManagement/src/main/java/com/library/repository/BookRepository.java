package com.library.repository;

/**
 * BookRepository - Data Access Layer
 * 
 * This class represents the repository layer in the application.
 * It is responsible for fetching book data and details.
 * 
 * In a real-world application, this would interact with a database.
 * For this example, it returns sample book details.
 */
public class BookRepository {

    /**
     * Retrieves sample book details.
     * 
     * In a real scenario, this method would query a database
     * and return actual book information.
     * 
     * @return A string containing sample book details
     */
    public String getBookDetails() {
        return "Book Details:\n" +
                "Title: The Spring Framework Guide\n" +
                "Author: John Doe\n" +
                "ISBN: 978-0-123456-78-9\n" +
                "Publisher: Tech Publishing Co.\n" +
                "Year: 2024\n" +
                "Availability: Available";
    }
}
