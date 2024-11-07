package com.inditex.web.controller;

import com.inditex.application.service.PriceService;
import com.inditex.application.service.PriceServiceImpl;
import com.inditex.web.dto.PriceDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

/**
 * REST controller for managing prices.
 */
@RestController
@RequestMapping("/api")
public class PriceController {

    private final PriceService priceService;

    /**
     * Constructor to inject the PriceService dependency.
     *
     * @param priceService The service for managing prices.
     */
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    /**
     * Retrieves the applicable price for a given product and brand at a specific date.
     *
     * @param productId The ID of the product for which to retrieve the price.
     * @param brandId   The ID of the brand associated with the product.
     * @param date      The date for which the price should be applicable.
     * @return A ResponseEntity containing the applicable price and the corresponding HTTP status.
     */
    @Operation(summary = "Retrieve applicable price",
            description = "Retrieves the applicable price for a given product and brand at a specific date.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved applicable price"),
            @ApiResponse(responseCode = "404", description = "Price not found for the specified criteria")
    })
    @GetMapping("/prices")
    public ResponseEntity<PriceDTO> getApplicablePrice(
            @Parameter(description = "ID of the product", required = true) @RequestParam Long productId,
            @Parameter(description = "ID of the brand", required = true) @RequestParam Long brandId,
            @Parameter(description = "Date for which the price should be applicable", required = true)
            @RequestParam("date") String date) {

        LocalDateTime localDate = LocalDateTime.parse(date);
        PriceDTO applicablePrice = priceService.getApplicablePrice(productId, brandId, localDate);
        return new ResponseEntity<>(applicablePrice, HttpStatus.OK);
    }
}
