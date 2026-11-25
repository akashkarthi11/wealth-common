package com.wealth.common.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.wealth.common.generic.BaseError;
import com.wealth.common.generic.GrowxException;
import com.wealth.common.logger.GrowxLogger;

@Configuration
public class DataSourceConfig {

    private static final GrowxLogger LOGGER =
            new GrowxLogger(DataSourceConfig.class);

    private final String url;
    private final String username;
    private final String encryptedPassword;

    public DataSourceConfig(
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String encryptedPassword) {

        this.url = url;
        this.username = username;
        this.encryptedPassword = encryptedPassword;
    }

    @Bean
    public DataSource dataSource() {
        try {
            LOGGER.info("Initializing DataSource configuration");

            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setUrl(url);
            dataSource.setUsername(username);

//            String password = encryptionUtil.decrypt(encryptedPassword);
            dataSource.setPassword(encryptedPassword);

            LOGGER.info("DataSource configured successfully");
            return dataSource;

        } catch (IllegalArgumentException ex) {
            LOGGER.error("Invalid datasource configuration", ex);
            throw new GrowxException(BaseError.INVALID_DATASOURCE_CONFIG, ex);

        } catch (Exception ex) {
            // encryption or unexpected failure
            LOGGER.error("Failed to initialize datasource", ex);
            throw new GrowxException(BaseError.DATABASE_CONNECTION_FAILED, ex);
        }
    }
}
