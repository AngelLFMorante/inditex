package com.inditex.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
 * Data Transfer Object (DTO) representing the price of a product.
 * This class encapsulates the information about a product's price details.
 */
public class PriceDTO {

    /**
     * id
     */
    @Schema(description = "The unique identifier for the price", example = "1")
    private Long id;

    /**
     * productId
     */
    @Schema(description = "The product's identifier", example = "2001")
    private Long productId;

    /**
     * brandId
     */
    @Schema(description = "The brand's identifier", example = "1001")
    private Long brandId;

    /**
     * priceList
     */
    @Schema(description = "The price list identifier", example = "1")
    private Integer priceList;

    /**
     * startDate
     */
    @Schema(description = "The start date of the price validity", example = "2020-12-31-23.59.59")
    private LocalDateTime startDate;

    /**
     * endDate
     */
    @Schema(description = "The end date of the price validity", example = "2020-12-31-23.59.59")
    private LocalDateTime endDate;

    /**
     * price
     */
    @Schema(description = "The price of the product", example = "99.99")
    private BigDecimal price;

    /**
     * curr
     */
    @Schema(description = "The currency of the price", example = "USD")
    private String curr;

    /**
     * Constructor to initialize the PriceDTO with the given parameters.
     *
     * @param id The unique identifier for the price.
     * @param productId The product's identifier.
     * @param brandId The brand's identifier.
     * @param priceList The price list identifier.
     * @param startDate The start date of the price validity.
     * @param endDate The end date of the price validity.
     * @param price The price amount.
     * @param curr The currency used for the price.
     */
    public PriceDTO(Long id,
                    Long productId,
                    Long brandId,
                    Integer priceList,
                    LocalDateTime startDate,
                    LocalDateTime endDate,
                    BigDecimal price,
                    String curr
    ) {
        this.id = id;
        this.productId = productId;
        this.brandId = brandId;
        this.priceList = priceList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.curr = curr;
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurr() {
        return curr;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }
}
