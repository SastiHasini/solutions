package com.library.main;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * LibraryApplication - Main Entry Point
 * 
 * This class demonstrates the Spring Framework's Inversion of Control (IoC) container
 * with XML-based configuration.
 * 
 * Key Spring Concepts Demonstrated:
 * 
 * 1. Spring IoC Container:
 *    - The Spring IoC container is responsible for creating objects (beans),
 *      wiring them together, and managing their lifecycle.
 *    - It reads the XML configuration file and instantiates beans as defined.
 * 
 * 2. Bean Configuration:
 *    - Beans are objects that are instantiated, assembled, and otherwise managed
 *      by the Spring IoC container.
 *    - In this example, beans are defined in applicationContext.xml using <bean> elements.
 *    - Each bean has an id (unique identifier) and a class (fully qualified class name).
 * 
 * 3. Dependency Injection (DI):
 *    - DI is a technique where objects receive their dependencies from external sources
 *      rather than creating them internally.
 *    - This application uses Constructor Injection, where BookRepository is injected
 *      into BookService through its constructor.
 *    - Benefits: Loose coupling, testability, and flexibility in component composition.
 * 
 * 4. Application Context Loading:
 *    - ClassPathXmlApplicationContext loads the Spring ApplicationContext from an XML
 *      configuration file located on the classpath.
 *    - The ApplicationContext is the interface to the Spring IoC container.
 * 
 * Workflow:
 * 1. Load the Spring ApplicationContext using ClassPathXmlApplicationContext
 * 2. The container reads applicationContext.xml
 * 3. The container creates BookRepository bean
 * 4. The container creates BookService bean and injects BookRepository
 * 5. Retrieve the BookService bean from the container
 * 6. Call business methods on the bean
 */
public class LibraryApplication {

    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║         Spring Framework XML Configuration Demo             ║");
        System.out.println("║                 Library Management System                   ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");

        System.out.println("[Main] Step 1: Initializing Spring IoC Container...");
        System.out.println("[Main] Loading applicationContext.xml from classpath\n");

        /*
         * Creating the Spring ApplicationContext using ClassPathXmlApplicationContext.
         * 
         * This line triggers the following sequence:
         * 1. Spring reads the XML configuration file (applicationContext.xml)
         * 2. Spring parses the <bean> elements
         * 3. Spring instantiates beans in the order they are defined
         * 4. Spring resolves and injects dependencies using constructor injection
         * 5. The ApplicationContext is fully initialized and ready to use
         */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("[Main] Step 2: Spring IoC Container initialized successfully!");
        System.out.println("[Main] All beans have been created and dependencies injected.\n");

        System.out.println("[Main] Step 3: Retrieving BookService bean from the container...");
        /*
         * Retrieve the BookService bean from the ApplicationContext using its id.
         * The id "bookService" must match the bean id defined in applicationContext.xml.
         * 
         * The getBean() method returns the singleton instance of BookService
         * that was created during container initialization.
         */
        BookService bookService = (BookService) applicationContext.getBean("bookService");

        System.out.println("[Main] Step 4: BookService bean retrieved successfully!\n");

        System.out.println("[Main] Step 5: Calling displayBookDetails() method...");
        /*
         * Call the business logic method on the BookService bean.
         * This method will use the injected BookRepository to retrieve and display book details.
         */
        bookService.displayBookDetails();

        System.out.println("[Main] Step 6: Closing the ApplicationContext...");
        /*
         * Close the ApplicationContext to release resources and clean up the container.
         * This calls the destroy methods of all beans (if any are defined).
         */
        if (applicationContext instanceof org.springframework.context.support.ClassPathXmlApplicationContext) {
            ((org.springframework.context.support.ClassPathXmlApplicationContext) applicationContext).close();
        }

        System.out.println("[Main] ApplicationContext closed. Program terminated successfully.\n");

        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║     Spring Framework Dependency Injection Demo Complete     ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
    }
}
