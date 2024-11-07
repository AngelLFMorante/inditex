package com.inditex.web.advice;

import com.inditex.application.exception.PriceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandlerTest {

    @Test
    void testHandlePriceNotFoundException(){
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

        PriceNotFoundException exception = new PriceNotFoundException("Price not found");

        ResponseEntity<String> responseEntity = globalExceptionHandler.handlePriceNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Price not found", responseEntity.getBody());
    }
}
