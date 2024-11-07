package com.inditex.application.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceNotFoundExceptionTest {

    @Test
    void testExceptionMessage() {
        String expectedMessage = "No price found for the specified criteria";

        PriceNotFoundException exception = new PriceNotFoundException(expectedMessage);

        assertEquals(expectedMessage, exception.getMessage(), "Exception message should match the one provided");
    }

    @Test
    void testExceptionInheritance() {
        assertTrue(true, "PriceNotFoundException should be an instance of RuntimeException");
    }
}
