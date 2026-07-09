# JpaHibernateComparison

This project demonstrates the difference between JPA, Hibernate, and Spring Data JPA.

## JPA

JPA is a specification. It defines annotations such as `@Entity`, `@Id`, and `@Table`, but it does not provide the implementation.

## Hibernate

Hibernate is a JPA implementation and a full ORM framework. It handles database mapping and persistence operations. In this project, `HibernateEmployeeService` shows the native Hibernate `SessionFactory` and `session.save(employee)` approach.

## Spring Data JPA

Spring Data JPA is an abstraction over JPA and Hibernate. It reduces boilerplate code by providing repository interfaces and automatic CRUD support. In this project, `EmployeeRepository` and `EmployeeService` show the Spring Data JPA approach.

## Code Comparison

Hibernate:

```java
session.save(employee);
```

Spring Data JPA:

```java
employeeRepository.save(employee);
```

## Run Steps

1. Create or use an H2 database in memory; no external setup is needed.
2. From the project folder, run `mvn clean install`.
3. Start the application with `mvn spring-boot:run`.
4. Use `POST /employees` to add employees.
5. Use `GET /employees` to view all employees.