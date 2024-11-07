package com.inditex.application.service;

import com.inditex.application.exception.PriceNotFoundException;
import com.inditex.web.dto.PriceDTO;

import java.time.LocalDateTime;

/**
 * Service interface for managing prices.
 * This interface defines the methods to retrieve price information based on specified criteria.
 */
public interface PriceService {

    /**
     * Retrieves the applicable price for a given product and brand at a specific date.
     *
     * @param productId The ID of the product for which to retrieve the price.
     * @param brandId   The ID of the brand associated with the product.
     * @param date      The date for which the price should be applicable.
     * @return The applicable Price entity, or null if no price is found.
     */
    PriceDTO getApplicablePrice(Long productId, Long brandId, LocalDateTime date) throws PriceNotFoundException;
}