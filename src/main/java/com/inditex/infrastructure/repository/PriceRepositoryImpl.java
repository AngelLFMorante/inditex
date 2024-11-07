package com.inditex.infrastructure.repository;

import com.inditex.domain.model.Price;
import com.inditex.domain.repository.PriceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * JPA implementation of the PriceRepository interface.
 * This class provides methods to retrieve Price entities from the database
 * based on specified criteria such as product ID, brand ID, and date range.
 */
public class PriceRepositoryImpl implements PriceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Finds the applicable price for a given product and brand at a specific date.
     *
     * @param productId The ID of the product for which to find the price.
     * @param brandId   The ID of the brand associated with the product.
     * @param date      The date for which the price should be applicable.
     * @return The Price entity if found, or null if no applicable price exists.
     */
    @Override
    public Optional<Price> findApplicablePrice(Long productId, Long brandId, LocalDateTime date) {
        String jpql = "SELECT p FROM Price p WHERE p.productId = :productId " +
                "AND p.brandId = :brandId " +
                "AND p.startDate <= :date " +
                "AND p.endDate >= :date " +
                "ORDER BY p.priority DESC";

        TypedQuery<Price> query = entityManager.createQuery(jpql, Price.class);
        query.setParameter("productId", productId);
        query.setParameter("brandId", brandId);
        query.setParameter("date", date);

        return query.setMaxResults(1).getResultStream().findFirst();
    }
}