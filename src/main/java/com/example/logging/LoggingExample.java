package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    // Create a static logger instance for this class.
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        // Log an error-level message.
        logger.error("This is an error message");

        // Log a warning-level message.
        logger.warn("This is a warning message");
    }
}
