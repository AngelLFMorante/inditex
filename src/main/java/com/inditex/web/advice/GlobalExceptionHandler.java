package com.inditex.web.advice;

import com.inditex.application.exception.PriceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for the Inditex application.
 * This class handles exceptions thrown by controllers and provides appropriate HTTP responses.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles the PriceNotFoundException and returns a 404 Not Found response.
     *
     * @param ex The exception thrown when no price is found.
     * @return ResponseEntity with the exception message and HTTP status code 404.
     */
    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<String> handlePriceNotFoundException(PriceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}

