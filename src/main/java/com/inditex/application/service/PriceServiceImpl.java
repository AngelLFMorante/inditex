package com.inditex.application.service;

import com.inditex.application.exception.PriceNotFoundException;
import com.inditex.domain.repository.PriceRepository;
import com.inditex.web.dto.PriceDTO;
import com.inditex.web.mapper.PriceMapper;

import java.time.LocalDateTime;

/**
 * Implementation of PriceService interface.
 * This class provides the business logic for managing prices and retrieving applicable prices.
 */
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;

    /**
     * Constructor to inject the PriceRepository dependency.
     *
     * @param priceRepository The repository for accessing price data.
     */
    public PriceServiceImpl(PriceRepository priceRepository, PriceMapper priceMapper) {
        this.priceRepository = priceRepository;
        this.priceMapper = priceMapper;
    }

    /**
     * Retrieves the applicable price for a given product and brand at a specific date.
     *
     * @param productId The ID of the product for which to retrieve the price.
     * @param brandId   The ID of the brand associated with the product.
     * @param date      The date for which the price should be applicable.
     * @return The applicable PriceDTO , or null if no price is found.
     */
    @Override
    public PriceDTO getApplicablePrice(Long productId, Long brandId, LocalDateTime date) throws PriceNotFoundException {
        return priceRepository.findApplicablePrice(productId, brandId, date)
                .map(priceMapper::toDto)
                .orElseThrow(() -> new PriceNotFoundException("No price found for the specified criteria."));
    }
}
