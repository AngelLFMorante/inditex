package com.inditex.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents the pricing details for a product within a specific time range.
 */
@Entity
@Table(name = "PRICES")
@Schema(description = "Represents the pricing details for a product within a specific time range.")
public final class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the price entry", example = "1")
    private Long id;

    @Column(name = "BRAND_ID")
    @Schema(description = "The unique identifier for the brand", example = "1001")
    private int brandId;

    @Column(name = "PRODUCT_ID")
    @Schema(description = "The unique identifier for the product", example = "2001")
    private int productId;

    @Column(name = "START_DATE")
    @Schema(description = "The date and time when the price becomes applicable", example = "2024-11-01T10:00:00")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    @Schema(description = "The date and time when the price ceases to be applicable", example = "2024-12-01T10:00:00")
    private LocalDateTime endDate;

    @Column(name = "PRICE_LIST")
    @Schema(description = "The identifier for the price list applicable", example = "1")
    private Integer priceList;

    @Column(name = "PRIORITY")
    @Schema(description = "The priority for price application", example = "1")
    private Integer priority;

    @Column(name = "PRICE")
    @Schema(description = "The final selling price of the product", example = "99.99")
    private BigDecimal price;

    @Column(name = "CURR")
    @Schema(description = "The currency in which the price is expressed", example = "USD")
    private String curr;

    public Price() {
    }

    /**
     * Constructs a new Price instance.
     *
     * @param brandId    the unique identifier for the brand
     * @param startDate  the date and time when the price becomes applicable
     * @param endDate    the date and time when the price ceases to be applicable
     * @param priceList  the identifier for the price list applicable
     * @param productId  the unique identifier for the product
     * @param priority   the priority for price application
     * @param price      the final selling price of the product
     * @param curr   the currency in which the price is expressed
     */
    public Price(int brandId, LocalDateTime startDate, LocalDateTime endDate, int priceList,
                 int productId, int priority, BigDecimal price, String curr) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return brandId == price1.brandId && productId == price1.productId && Objects.equals(id, price1.id) && Objects.equals(startDate, price1.startDate) && Objects.equals(endDate, price1.endDate) && Objects.equals(priceList, price1.priceList) && Objects.equals(priority, price1.priority) && Objects.equals(price, price1.price) && Objects.equals(curr, price1.curr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brandId, productId, startDate, endDate, priceList, priority, price, curr);
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", brandId=" + brandId +
                ", productId=" + productId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", priceList=" + priceList +
                ", priority=" + priority +
                ", price=" + price +
                ", curr='" + curr + '\'' +
                '}';
    }
}
