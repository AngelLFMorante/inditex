package com.inditex.web.dto;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceDTOTest {

    @Test
    void testPriceDTOConstructorAndGetters() {
        LocalDateTime startDate = LocalDateTime.of(2020, 6, 14, 10, 0, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2020, 12, 31, 23, 59, 59, 0);

        PriceDTO priceDTO = new PriceDTO(
                1L,  // id
                35455L,  // productId
                1L,  // brandId
                1,  // priceList
                startDate,  // startDate
                endDate,  // endDate
                new BigDecimal("35.50"),  // price
                "EUR"  // curr
        );

        assertEquals(1L, priceDTO.getId());
        assertEquals(35455L, priceDTO.getProductId());
        assertEquals(1L, priceDTO.getBrandId());
        assertEquals(1, priceDTO.getPriceList());
        assertEquals(startDate, priceDTO.getStartDate());
        assertEquals(endDate, priceDTO.getEndDate());
        assertEquals(new BigDecimal("35.50"), priceDTO.getPrice());
        assertEquals("EUR", priceDTO.getCurr());
    }

    @Test
    void testPriceDTOSetters() {
        PriceDTO priceDTO = new PriceDTO(null, null, null, null, null, null, null, null);

        priceDTO.setId(2L);
        priceDTO.setProductId(12345L);
        priceDTO.setBrandId(2L);
        priceDTO.setPriceList(3);
        priceDTO.setStartDate(LocalDateTime.of(2021, 1, 1, 12, 0, 0, 0));
        priceDTO.setEndDate(LocalDateTime.of(2021, 12, 31, 23, 59, 59, 0));
        priceDTO.setPrice(new BigDecimal("50.75"));
        priceDTO.setCurr("USD");

        assertEquals(2L, priceDTO.getId());
        assertEquals(12345L, priceDTO.getProductId());
        assertEquals(2L, priceDTO.getBrandId());
        assertEquals(3, priceDTO.getPriceList());
        assertEquals(LocalDateTime.of(2021, 1, 1, 12, 0, 0, 0), priceDTO.getStartDate());
        assertEquals(LocalDateTime.of(2021, 12, 31, 23, 59, 59, 0), priceDTO.getEndDate());
        assertEquals(new BigDecimal("50.75"), priceDTO.getPrice());
        assertEquals("USD", priceDTO.getCurr());
    }
}
