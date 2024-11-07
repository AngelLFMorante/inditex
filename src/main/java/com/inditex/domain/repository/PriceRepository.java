package com.inditex.domain.repository;

import com.inditex.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Repository interface for accessing Price data.
 */
public interface PriceRepository {

    /**
     * Finds the applicable price for a given product and brand within a specific date.
     *
     * @param productId the unique identifier of the product
     * @param brandId   the unique identifier of the brand
     * @param date      the date and time to check for applicable price
     * @return the applicable Price, or null if no price is found
     */
    Optional<Price> findApplicablePrice(Long productId, Long brandId, LocalDateTime date);
}
