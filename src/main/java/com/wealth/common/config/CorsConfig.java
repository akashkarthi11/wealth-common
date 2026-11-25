package com.wealth.common.config;

import java.util.List;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wealth.common.logger.DoczLogger;
import com.wealth.common.properties.CorsProperties;

@Configuration
@EnableConfigurationProperties(CorsProperties.class)
public class CorsConfig {
    private static final DoczLogger LOGGER = new DoczLogger(CorsConfig.class);

    private final CorsProperties corsProperties;

    public CorsConfig(CorsProperties corsProperties) {
        this.corsProperties = corsProperties;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        try {
        	LOGGER.info("corsConfigurer");
            LOGGER.info("Initializing CORS configuration");
            WebMvcConfigurer configurer = new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    LOGGER.info("Setting up CORS mappings");
                    registry.addMapping(corsProperties.getMapping())
                            .allowedOrigins(toArray(corsProperties.getAllowedOrigins()))
                            .allowedOriginPatterns(toArray(corsProperties.getAllowedOriginPatterns()))
                            .allowedMethods(toArray(corsProperties.getAllowedMethods()))
                            .allowedHeaders(toArray(corsProperties.getAllowedHeaders()))
                            .allowCredentials(corsProperties.isAllowCredentials())
                            .maxAge(3600);
                }
            };
            LOGGER.info("CORS configuration initialized successfully");
            return configurer;
        } catch (Exception e) {
            LOGGER.error("Failed to initialize CORS configuration: " + e.getMessage());
            throw e;
        }
    }

    @Bean
    public CorsFilter corsFilter() {
        try {
        	LOGGER.info("corsFilter");
            LOGGER.info("Creating CORS filter. allowedOrigins=" + corsProperties.getAllowedOrigins()
                    + ", allowedOriginPatterns=" + corsProperties.getAllowedOriginPatterns()
                    + ", allowCredentials=" + corsProperties.isAllowCredentials());
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowedOrigins(corsProperties.getAllowedOrigins());
            config.setAllowedOriginPatterns(corsProperties.getAllowedOriginPatterns());
            config.setAllowedHeaders(corsProperties.getAllowedHeaders());
            config.setAllowedMethods(corsProperties.getAllowedMethods());
            config.setAllowCredentials(corsProperties.isAllowCredentials());
            source.registerCorsConfiguration(corsProperties.getMapping(), config);
            LOGGER.info("CORS filter created successfully");
            return new CorsFilter(source);
        } catch (Exception e) {
            LOGGER.error("Failed to create CORS filter: " + e.getMessage());
            throw e;
        }
    }

    private static String[] toArray(List<String> values) {
        return values == null ? new String[0] : values.toArray(new String[0]);
    }
}
