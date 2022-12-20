package com.example.clevertec_test_task.exception;

public class DBNotFoundException extends RuntimeException {
    public DBNotFoundException(String message) {
        super(message);
    }
}
