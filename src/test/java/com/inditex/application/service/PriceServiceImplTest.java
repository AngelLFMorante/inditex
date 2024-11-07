package com.inditex.application.service;

import com.inditex.application.exception.PriceNotFoundException;
import com.inditex.domain.model.Price;
import com.inditex.domain.repository.PriceRepository;
import com.inditex.web.dto.PriceDTO;
import com.inditex.web.mapper.PriceMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceServiceImplTest {

    @Mock
    private PriceRepository priceRepository;

    @Mock
    private PriceMapper priceMapper;

    @InjectMocks
    private PriceServiceImpl priceService;

    private LocalDateTime testDate;
    private final Long productId = 35455L;
    private final Long brandId = 1L;

    @BeforeEach
    public void setUp() {
        testDate = LocalDateTime.of(
                2020,
                6,
                14,
                10,
                0,
                0,
                0
        );
    }

    @Test
    void testGetApplicablePrice_WhenPriceFound_ShouldReturnPriceDTO() {
        Price price = new Price(
                1,
                LocalDateTime.of(
                        2020,
                        6,
                        14,
                        0,
                        0,
                        0,
                        0
                ),
                LocalDateTime.of(
                        2020,
                        12,
                        31,
                        23,
                        59,
                        59,
                        0
                ),
                1, 35455, 1, BigDecimal.valueOf(35.50), "EUR");

        PriceDTO priceDTO = new PriceDTO(
                1L,
                35455L,
                1L,
                1,
                LocalDateTime.of(
                        2020,
                        6,
                        14,
                        0,
                        0,
                        0,
                        0
                ),
                LocalDateTime.of(
                        2020,
                        12,
                        31,
                        23,
                        59,
                        59,
                        0
                ),
                BigDecimal.valueOf(35.50),
                "EUR"
        );

        when(priceRepository.findApplicablePrice(productId, brandId, testDate)).thenReturn(Optional.of(price));

        when(priceMapper.toDto(price)).thenReturn(priceDTO);

        PriceDTO result = priceService.getApplicablePrice(productId, brandId, testDate);

        assertNotNull(result);
        assertEquals(priceDTO.getProductId(), result.getProductId());
        assertEquals(priceDTO.getBrandId(), result.getBrandId());
        assertEquals(priceDTO.getPrice(), result.getPrice());
    }

    @Test
    void testGetApplicablePrice_WhenPriceNotFound_ShouldThrowPriceNotFoundException() {
        when(priceRepository.findApplicablePrice(productId, brandId, testDate)).thenReturn(Optional.empty());

        assertThrows(PriceNotFoundException.class, () ->
                priceService.getApplicablePrice(productId, brandId, testDate)
        );
    }
}
