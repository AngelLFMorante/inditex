package com.inditex.infrastructure.config;

import com.inditex.application.service.PriceService;
import com.inditex.application.service.PriceServiceImpl;
import com.inditex.domain.repository.PriceRepository;
import com.inditex.infrastructure.repository.PriceRepositoryImpl;
import com.inditex.web.mapper.PriceMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for defining beans used throughout the application.
 * This class provides the necessary configuration for service, repository, and mapper beans.
 */
@Configuration
public class ApplicationConfig {

    /**
     * Creates a PriceRepository bean.
     *
     * @return A new instance of PriceRepositoryImpl.
     */
    @Bean
    public PriceRepository priceRepository() {
        return new PriceRepositoryImpl();
    }

    /**
     * Creates a PriceMapper bean.
     *
     * @return A new instance of PriceMapper.
     */
    @Bean
    public PriceMapper priceMapper() {
        return Mappers.getMapper(PriceMapper.class);
    }

    /**
     * Creates a PriceService bean.
     *
     * @return A new instance of PriceServiceImpl with the necessary dependencies.
     */
    @Bean
    public PriceService priceService() {
        return new PriceServiceImpl(priceRepository(), priceMapper());
    }
}
