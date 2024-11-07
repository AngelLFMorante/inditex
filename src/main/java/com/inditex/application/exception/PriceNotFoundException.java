package com.inditex.application.exception;

/**
 * Exception thrown when a price cannot be found for a given product, brand, or date.
 * This exception is typically used in cases where the requested price does not exist in the database.
 */
public class PriceNotFoundException extends RuntimeException {
    /**
     * Constructs a new PriceNotFoundException with the specified detail message.
     *
     * @param message The detail message which is saved for later retrieval by the {@link #getMessage()} method.
     */
    public PriceNotFoundException(String message) {
        super(message);
    }
}
