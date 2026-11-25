package com.wealth.common.config;

import com.wealth.common.logger.DoczLogger;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.ssl.DefaultHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactoryBuilder;
import org.apache.hc.core5.ssl.SSLContexts;
import org.springframework.core.io.ClassPathResource;


import feign.Client;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.RequestInterceptor;
@Configuration
public class NexusServiceFeignClientMtlsConfig {

    private static final DoczLogger LOGGER = new DoczLogger(NexusServiceFeignClientMtlsConfig.class);

//    @Bean
//    public Client nexusFeignClient(
//            @Value("${mtls-server.keystore.password}") String keyStorePassword,
//            @Value("${mtls-server.truststore.password}") String trustStorePassword,
//            @Value("${mtls-server.cert-path.nexus-service.client}") String clientCert,
//            @Value("${mtls-server.cert-path.truststore}") String truststorePath
//    ) {
//        try {
//            // 🔐 Load Client Keystore
//            KeyStore keyStore = KeyStore.getInstance("PKCS12");
//            keyStore.load(new java.io.FileInputStream(clientCert), keyStorePassword.toCharArray());
//
//            // 🔐 Load Truststore
//            KeyStore trustStore = KeyStore.getInstance("PKCS12");
//            trustStore.load(new java.io.FileInputStream(truststorePath), trustStorePassword.toCharArray());
//
//            // 🔐 Build SSLContext
//            SSLContext sslContext = SSLContexts.custom()
//                    .loadKeyMaterial(keyStore, keyStorePassword.toCharArray())
//                    .loadTrustMaterial(trustStore, null)
//                    .build();
//
//            // 🔐 Create SSL Socket Factory
//            var sslSocketFactory = SSLConnectionSocketFactoryBuilder.create()
//                    .setSslContext(sslContext)
//                    .setHostnameVerifier(new DefaultHostnameVerifier())
//                    .build();
//
//            // 🔐 Create Connection Manager
//            var connectionManager = org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder
//                    .create().setSSLSocketFactory(sslSocketFactory).build();
//
//            // 🔐 Build HttpClient
//            HttpClient httpClient = HttpClients.custom()
//                    .setConnectionManager(connectionManager)
//                    .build();
//
//            return new feign.hc5.ApacheHttp5Client(httpClient);
//
//        } catch (Exception e) {
//            LOGGER.error("Failed to configure Feign mTLS client", e);
//            throw new RuntimeException("Failed to configure Feign mTLS", e);
//        }
//    }
    @Bean
    public RequestInterceptor commontraceCorrelationInterceptorForNexusService() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                // Reuse traceId from MDC if present
                String traceId = MDC.get("traceId");
                if (traceId != null) {
                    template.header("X-Trace-ID", traceId);
                }

                // Reuse correlationId from MDC or generate if missing
                String correlationId = MDC.get("correlationId");
                if (correlationId == null) {
                    correlationId = java.util.UUID.randomUUID().toString();
                    MDC.put("correlationId", correlationId);
                }
                template.header("X-Correlation-ID", correlationId);
            }

		
        };
    }
    
}
