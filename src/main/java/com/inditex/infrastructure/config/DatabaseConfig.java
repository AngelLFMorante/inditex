package com.inditex.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Configuration class for the database of the application.
 * <p>
 * This class provides the necessary configuration for connecting to the in-memory H2 database.
 * It uses the H2 driver to establish a data source connection to the in-memory database.
 * </p>
 */
@Configuration
public class DatabaseConfig {

    /**
     * Configures and provides a {@link DataSource} for the database.
     *
     * @return a {@link DataSource} that uses the H2 driver to connect to the in-memory database.
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");

        return dataSource;
    }
}

