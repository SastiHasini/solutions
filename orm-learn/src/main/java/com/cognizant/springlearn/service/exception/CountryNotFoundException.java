package com.cognizant.springlearn.service.exception;

public class CountryNotFoundException extends RuntimeException {

    public CountryNotFoundException() {
        super();
    }

    public CountryNotFoundException(String message) {
        super(message);
    }

    public CountryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}