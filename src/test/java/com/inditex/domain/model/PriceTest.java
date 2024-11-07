package com.inditex.domain.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PriceTest {

    @Test
    void testPriceConstructorAndGetters() {
        LocalDateTime startDate = LocalDateTime.of(
                2020,
                6,
                14,
                10,
                0,
                0,
                0
        );
        LocalDateTime endDate = LocalDateTime.of(
                2020,
                12,
                31,
                23,
                59,
                59,
                0
        );

        Price price = new Price(
                1,
                startDate,
                endDate,
                1,
                35455,
                0,
                new BigDecimal("35.50"),
                "EUR"
        );
        price.setId(1L);

        assertEquals(1L, price.getId());
        assertEquals(1, price.getBrandId());
        assertEquals(startDate, price.getStartDate());
        assertEquals(endDate, price.getEndDate());
        assertEquals(1, price.getPriceList());
        assertEquals(35455, price.getProductId());
        assertEquals(0, price.getPriority());
        assertEquals(new BigDecimal("35.50"), price.getPrice());
        assertEquals("EUR", price.getCurr());
    }

    @Test
    void testPriceSetters() {
        Price price = new Price();

        price.setId(1L);
        price.setBrandId(2);
        price.setProductId(12345);
        price.setStartDate(LocalDateTime.of(
                2021,
                1,
                1,
                12,
                0,
                0,
                0
        ));
        price.setEndDate(LocalDateTime.of(
                2021,
                12,
                31,
                23,
                59,
                59,
                0
        ));
        price.setPriceList(2);
        price.setPriority(1);
        price.setPrice(new BigDecimal("50.75"));
        price.setCurr("USD");

        assertEquals(1L, price.getId());
        assertEquals(2, price.getBrandId());
        assertEquals(12345, price.getProductId());
        assertEquals(LocalDateTime.of(
                2021,
                1,
                1,
                12,
                0,
                0,
                0
                ),
                price.getStartDate()
        );
        assertEquals(LocalDateTime.of(
                2021,
                12,
                31,
                23,
                59,
                59,
                0
                ),
                price.getEndDate()
        );
        assertEquals(2, price.getPriceList());
        assertEquals(1, price.getPriority());
        assertEquals(new BigDecimal("50.75"), price.getPrice());
        assertEquals("USD", price.getCurr());
    }

    @Test
    void testEqualsAndHashCode() {
        LocalDateTime startDate = LocalDateTime.of(
                2020,
                6,
                14,
                10,
                0,
                0,
                0
        );
        LocalDateTime endDate = LocalDateTime.of(
                2020,
                12,
                31,
                23,
                59,
                59,
                0
        );
        Price price1 = new Price(
                1,
                startDate,
                endDate,
                1,
                35455,
                0,
                new BigDecimal("35.50"),
                "EUR"
        );
        Price price2 = new Price(
                1,
                startDate,
                endDate,
                1,
                35455,
                0,
                new BigDecimal("35.50"),
                "EUR"
        );

        assertEquals(price1, price2);
        assertEquals(price1.hashCode(), price2.hashCode());

        Price price3 = new Price(
                2,
                startDate,
                endDate,
                2,
                12345,
                1,
                new BigDecimal("50.00"),
                "USD"
        );
        assertNotEquals(price1, price3);
        assertNotEquals(price1.hashCode(), price3.hashCode());
    }

    @Test
    void testToString() {
        LocalDateTime startDate = LocalDateTime.of(
                2020,
                6,
                14,
                10,
                0,
                0,
                0
        );
        LocalDateTime endDate = LocalDateTime.of(
                2020,
                12,
                31,
                23,
                59,
                59,
                0
        );
        Price price = new Price(
                1,
                startDate,
                endDate,
                1,
                35455,
                0,
                new BigDecimal("35.50"),
                "EUR"
        );

        String expectedToString = "Price{" +
                "id=null, " +
                "brandId=1, " +
                "productId=35455, " +
                "startDate=2020-06-14T10:00, " +
                "endDate=2020-12-31T23:59:59, " +
                "priceList=1, " +
                "priority=0, " +
                "price=35.50, " +
                "curr='EUR'" +
                "}";
        assertEquals(expectedToString, price.toString());
    }


}
