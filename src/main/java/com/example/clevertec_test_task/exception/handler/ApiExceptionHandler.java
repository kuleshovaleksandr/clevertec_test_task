package com.example.clevertec_test_task.exception.handler;

import com.example.clevertec_test_task.exception.DBNotFoundException;
import com.example.clevertec_test_task.exception.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value={DBNotFoundException.class})
    public ResponseEntity<Object> handleDBNotFoundException(DBNotFoundException e) {
        ExceptionDto exceptionDto = new ExceptionDto(
                e.getMessage(),
                e, HttpStatus.NOT_FOUND,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value={IOException.class})
    public ResponseEntity<Object> handleIOException(IOException e) {
        ExceptionDto exceptionDto = new ExceptionDto(
                e.getMessage(),
                e, HttpStatus.NOT_FOUND,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
