# LibraryManagement - Spring Framework XML Configuration Demo

A comprehensive Maven project demonstrating the Spring Framework's Inversion of Control (IoC) container with XML-based bean configuration and dependency injection.

## Project Overview

This project showcases fundamental Spring Framework concepts including:
- **Spring IoC Container**: Manages object creation and lifecycle
- **Bean Configuration**: XML-based bean definitions and management
- **Dependency Injection**: Constructor-based dependency injection
- **Application Context**: Loading and using the Spring container

## Project Structure

```
LibraryManagement/
├── pom.xml                              # Maven project configuration
├── README.md                            # Project documentation
└── src/
    └── main/
        ├── java/
        │   └── com/library/
        │       ├── repository/
        │       │   └── BookRepository.java    # Data access layer
        │       ├── service/
        │       │   └── BookService.java       # Business logic layer
        │       └── main/
        │           └── LibraryApplication.java # Main entry point
        └── resources/
            └── applicationContext.xml         # Spring XML configuration
```

## Key Components

### 1. BookRepository.java
- **Role**: Data Access Layer (Repository Pattern)
- **Responsibility**: Provides book data retrieval
- **Method**: `getBookDetails()` - Returns sample book information

### 2. BookService.java
- **Role**: Business Logic Layer (Service Pattern)
- **Dependency**: BookRepository (injected via constructor)
- **Method**: `displayBookDetails()` - Calls repository to display book information
- **Injection Type**: Constructor Injection

### 3. LibraryApplication.java
- **Role**: Application Entry Point
- **Responsibility**: Initializes Spring IoC container and orchestrates the application flow
- **Key Operations**:
  - Loads Spring ApplicationContext from XML configuration
  - Retrieves BookService bean from container
  - Calls business methods
  - Properly closes the application context

### 4. applicationContext.xml
- **Bean Definitions**:
  - `bookRepository`: Instance of BookRepository
  - `bookService`: Instance of BookService with BookRepository injected
- **Injection Configuration**: Constructor-based injection via `<constructor-arg>`

## Spring Concepts Explained

### IoC Container
The Spring IoC (Inversion of Control) container is responsible for:
- Creating bean instances
- Wiring beans together based on configuration
- Managing bean lifecycle (creation, initialization, destruction)
- Resolving dependencies

### Bean Definition
A bean is an object that is instantiated, assembled, and managed by the Spring IoC container. In this project:
- Beans are defined in `applicationContext.xml`
- Each bean has a unique `id` and a `class` (fully qualified name)
- Beans can be retrieved using `applicationContext.getBean(id)`

### Dependency Injection (DI)
Constructor Injection is used to inject the BookRepository dependency into BookService:
- Dependencies are provided via constructor parameters
- Makes dependencies explicit and immutable
- Promotes loose coupling between components
- Improves testability

### Application Context
The `ApplicationContext` is the interface to the Spring IoC container:
- `ClassPathXmlApplicationContext`: Loads context from XML files on the classpath
- Provides access to beans via `getBean()` method
- Should be properly closed to release resources

## Dependencies

### Spring Framework (Version 5.3.28)
- **spring-core**: Core utilities and base framework classes
- **spring-beans**: Bean factory and bean support
- **spring-context**: Application context and IoC container

### Logging
- **SLF4J**: Simple logging facade
- **SLF4J Simple**: Simple implementation of SLF4J

## Building the Project

### Prerequisites
- Java 11 or higher
- Maven 3.6.0 or higher
- Spring Framework 5.3.28

### Build Commands

**Clean and Build:**
```bash
mvn clean install
```

**Compile Only:**
```bash
mvn compile
```

**Run Tests:**
```bash
mvn test
```

**Package the Application:**
```bash
mvn package
```

## Running the Application

### Option 1: Using Maven Exec Plugin (Recommended)
Add the following to your pom.xml and run:
```bash
mvn exec:java -Dexec.mainClass="com.library.main.LibraryApplication"
```

### Option 2: Using Java Command
After building with `mvn package`:
```bash
java -jar target/LibraryManagement-executable.jar
```

### Option 3: From IDE
Run the `main()` method in `LibraryApplication.java` directly from your IDE.

## Expected Output

```
╔════════════════════════════════════════════════════════════╗
║         Spring Framework XML Configuration Demo             ║
║                 Library Management System                   ║
╚════════════════════════════════════════════════════════════╝

[Main] Step 1: Initializing Spring IoC Container...
[Main] Loading applicationContext.xml from classpath

[Main] Step 2: Spring IoC Container initialized successfully!
[Main] All beans have been created and dependencies injected.

[Main] Step 3: Retrieving BookService bean from the container...
[BookService] Constructor: BookRepository injected successfully.
[Main] Step 4: BookService bean retrieved successfully!

[Main] Step 5: Calling displayBookDetails() method...

========================================
[BookService] Displaying Book Details:
========================================
Book Details:
Title: The Spring Framework Guide
Author: John Doe
ISBN: 978-0-123456-78-9
Publisher: Tech Publishing Co.
Year: 2024
Availability: Available
========================================

[Main] Step 6: Closing the ApplicationContext...
[Main] ApplicationContext closed. Program terminated successfully.

╔════════════════════════════════════════════════════════════╗
║     Spring Framework Dependency Injection Demo Complete     ║
╚════════════════════════════════════════════════════════════╝
```

## Architecture Diagram

```
┌─────────────────────────────────────────────────┐
│            LibraryApplication                    │
│                  (Main)                          │
└────────────────────┬────────────────────────────┘
                     │
                     │ uses
                     ▼
┌─────────────────────────────────────────────────┐
│      Spring IoC Container                        │
│  (ApplicationContext - Loads XML Config)        │
└──────┬──────────────────────────────┬───────────┘
       │                              │
       │ creates & manages            │ creates & manages
       ▼                              ▼
┌──────────────────┐         ┌──────────────────┐
│   BookRepository │         │   BookService    │
│   (Repository)   │◄────────│   (Service)      │
│                  │ injected│                  │
└──────────────────┘ via     └──────────────────┘
       ▲           constructor         │
       │                              │ uses
       │                              ▼
       └──────────────────────────────┘
```

## Configuration Details

### Constructor Injection in applicationContext.xml
```xml
<bean id="bookService" class="com.library.service.BookService">
    <constructor-arg ref="bookRepository"/>
</bean>
```

This configuration tells Spring to:
1. Create an instance of BookService
2. Get the BookRepository bean (with id="bookRepository")
3. Pass it to the BookService constructor
4. Store the result with id="bookService"

### Application Context Loading in Java Code
```java
ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
BookService bookService = (BookService) applicationContext.getBean("bookService");
```

This code:
1. Creates an ApplicationContext that reads from applicationContext.xml
2. Spring automatically creates all beans
3. Retrieves the BookService bean by its id
4. The BookRepository dependency is already injected

## Best Practices Demonstrated

1. **Layered Architecture**: Separation of concerns (repository, service, main)
2. **Dependency Injection**: Loose coupling between components
3. **Constructor Injection**: Explicit, immutable dependencies
4. **XML Configuration**: Externalized bean configuration
5. **Resource Management**: Proper closing of ApplicationContext
6. **Code Documentation**: Comprehensive comments explaining Spring concepts
7. **Maven Conventions**: Standard directory structure and naming

## Learning Outcomes

After studying this project, you will understand:
- How Spring IoC container manages beans
- How to configure beans using XML
- How constructor injection works in Spring
- How to load and use ApplicationContext
- Best practices for Spring application development
- Layered architecture patterns
- Dependency injection principles

## Future Enhancements

Consider extending this project with:
- Annotation-based configuration (@Configuration, @Bean)
- Setter injection examples
- Bean lifecycle methods (init-method, destroy-method)
- Scope configurations (singleton, prototype)
- Multiple bean instances
- Integration with databases
- Unit tests using Spring Test Framework

## References

- [Spring Framework Official Documentation](https://docs.spring.io/spring-framework/reference/)
- [Spring XML Configuration Guide](https://docs.spring.io/spring-framework/reference/core/beans/basics.html)
- [Dependency Injection Pattern](https://martinfowler.com/articles/injection.html)
- [Maven Official Documentation](https://maven.apache.org/guides/)

## License

This project is provided as an educational resource. Feel free to use and modify it for learning purposes.

## Author

Created as a Spring Framework learning resource.

---

**Happy Learning with Spring Framework!** 🚀
