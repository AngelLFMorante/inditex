package com.inditex.infrastructure.repository;

import com.inditex.domain.model.Price;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceRepositoryImplTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<Price> typedQuery;

    @InjectMocks
    private PriceRepositoryImpl priceRepository;

    private final Long productId = 35455L;
    private final Long brandId = 1L;
    private final LocalDateTime date = LocalDateTime.of(
            2020,
            6,
            14,
            10,
            0,
            0,
            0
    );


    @Test
    void testFindApplicablePriceFound() {
        Price price = new Price(
                1,
                LocalDateTime.of(
                        2020,
                        6,
                        14,
                        0,
                        0,
                        0,
                        0),
                LocalDateTime.of(
                        2020,
                        12,
                        31,
                        23,
                        59,
                        59,
                        0),
                1,
                35455,
                1,
                BigDecimal.valueOf(35.50),
                "EUR"
        );

        when(entityManager.createQuery(anyString(), eq(Price.class))).thenReturn(typedQuery);
        when(typedQuery.setParameter("productId", productId)).thenReturn(typedQuery);
        when(typedQuery.setParameter("brandId", brandId)).thenReturn(typedQuery);
        when(typedQuery.setParameter("date", date)).thenReturn(typedQuery);
        when(typedQuery.setMaxResults(1)).thenReturn(typedQuery);
        when(typedQuery.getResultStream()).thenReturn(Stream.of(price));

        Optional<Price> result = priceRepository.findApplicablePrice(productId, brandId, date);

        assertTrue(result.isPresent());

        verify(typedQuery).setParameter("productId", productId);
        verify(typedQuery).setParameter("brandId", brandId);
        verify(typedQuery).setParameter("date", date);
    }

    @Test
    void testFindApplicablePriceNotFound() {
        when(entityManager.createQuery(anyString(), eq(Price.class))).thenReturn(typedQuery);
        when(typedQuery.setParameter("productId", productId)).thenReturn(typedQuery);
        when(typedQuery.setParameter("brandId", brandId)).thenReturn(typedQuery);
        when(typedQuery.setParameter("date", date)).thenReturn(typedQuery);
        when(typedQuery.setMaxResults(1)).thenReturn(typedQuery);
        when(typedQuery.getResultStream()).thenReturn(Stream.empty());

        Optional<Price> result = priceRepository.findApplicablePrice(productId, brandId, date);

        assertTrue(result.isEmpty());
    }
}
