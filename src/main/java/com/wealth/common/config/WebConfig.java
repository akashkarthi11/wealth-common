package com.wealth.common.config;


import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.XXssProtectionHeaderWriter;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

import com.wealth.common.logger.KarthiLogger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.media.StringSchema;


@Configuration
public class WebConfig implements WebMvcConfigurer {
    private static final KarthiLogger LOGGER = new KarthiLogger(WebConfig.class);

    // Each service (wealth-bff, wealth-bss) supplies its own HandlerInterceptor bean(s) in its own
    // package - wealth-common only wires whatever the consuming service's context happens to provide.
    private final List<HandlerInterceptor> interceptors;

    public WebConfig(List<HandlerInterceptor> interceptors) {
        this.interceptors = interceptors;
        LOGGER.info("WebConfig initialized with " + interceptors.size() + " interceptor(s)");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        try {
        	LOGGER.info("addInterceptors");
            LOGGER.info("Adding interceptors to registry");
            for (HandlerInterceptor interceptor : interceptors) {
                registry.addInterceptor(interceptor);
            }
            LOGGER.info("Interceptors added successfully");
        } catch (Exception e) {
            LOGGER.error("Failed to add interceptors: " + e.getMessage());
            throw e;
        }
    }

    @Configuration
    @EnableWebSecurity
    public class SecurityConfig {
        private final KarthiLogger SECURITY_LOGGER = new KarthiLogger(SecurityConfig.class);

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http,
                @Value("${karthi.security-headers.content-security-policy}") String contentSecurityPolicy) throws Exception {
            try {
                SECURITY_LOGGER.info("Configuring security filter chain");
                http
                    .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                    )
                    .csrf(csrf -> csrf.disable())
                    .headers(headers -> headers
                        .contentSecurityPolicy(csp -> csp.policyDirectives(contentSecurityPolicy))
                        // VAPT #19: send X-XSS-Protection: 1; mode=block
                        .xssProtection(xss -> xss.headerValue(XXssProtectionHeaderWriter.HeaderValue.ENABLED_MODE_BLOCK))
                        // VAPT #17: HSTS on every response; TLS ends at the gateway, so not only on isSecure() requests
                        .httpStrictTransportSecurity(hsts -> hsts.includeSubDomains(true).maxAgeInSeconds(31536000)
                                .requestMatcher(AnyRequestMatcher.INSTANCE))
                    );
                SECURITY_LOGGER.info("Security headers configured. contentSecurityPolicy=" + contentSecurityPolicy);
                SECURITY_LOGGER.info("Security filter chain configured successfully");
                return http.build();
            } catch (Exception e) {
                SECURITY_LOGGER.error("Failed to configure security filter chain: " + e.getMessage());
                throw e;
            }
        }
    }
    



    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
            .info(new Info().title("Your API").version("1.0"))

            // Add both security requirements to all operations
            .addSecurityItem(
                new SecurityRequirement()
                    .addList("bearerAuth")
                    .addList("appidAuth")
            )

            .components(
                new Components()
                    .addSecuritySchemes("bearerAuth",
                        new SecurityScheme()
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT")
                    )

                    // New APPIKEY Header for "appid"
                    .addSecuritySchemes("appidAuth",
                        new SecurityScheme()
                            .type(SecurityScheme.Type.APIKEY)
                            .name("appid")          // header name
                            .in(SecurityScheme.In.HEADER)
                    )
            );
    }


 
}