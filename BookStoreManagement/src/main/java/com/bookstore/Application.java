package com.bookstore;

import com.bookstore.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        try {
            BookService bookService = context.getBean(BookService.class);
            bookService.displayBook();
        } finally {
            context.close();
        }
    }
}