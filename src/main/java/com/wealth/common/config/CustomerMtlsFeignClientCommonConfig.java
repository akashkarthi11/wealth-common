package com.wealth.common.config;

import org.slf4j.MDC;

import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.ssl.SSLContexts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.wealth.common.generic.GrowxException;
import com.wealth.common.utils.generic.MyCustomErrorDecoder;

import feign.Client;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.codec.ErrorDecoder;
@Configuration
public class CustomerMtlsFeignClientCommonConfig {

    @Bean
    public ErrorDecoder errorCommonCustomerDecoder() {
        return new MyCustomErrorDecoder();
    }

//    @Bean
//    public Client feignCommonCustomersClient(
//            @Value("${mtls-server.keystore.password}") String keyStorePassword,
//            @Value("${mtls-server.truststore.password}") String trustStorePassword,
//            @Value("${mtls-server.cert-path.customers-service.client}") String clientCert,
//            @Value("${mtls-server.cert-path.truststore}") String truststore) {
//
//        try {
//            // 🔐 Load Client Keystore
//            KeyStore keyStore = KeyStore.getInstance("PKCS12");
//            keyStore.load(new java.io.FileInputStream(clientCert), keyStorePassword.toCharArray());
//
//            // 🔐 Load Truststore
//            KeyStore trustStore = KeyStore.getInstance("PKCS12");
//            trustStore.load(new java.io.FileInputStream(truststore), trustStorePassword.toCharArray());
//
//            // 🔐 Build SSLContext
//            SSLContext sslContext = SSLContexts.custom()
//                    .loadKeyMaterial(keyStore, keyStorePassword.toCharArray())
//                    .loadTrustMaterial(trustStore, null)
//                    .build();
//
//            // 🔐 Create SSL Socket Factory
//            var sslSocketFactory = org.apache.hc.client5.http.ssl.SSLConnectionSocketFactoryBuilder.create()
//                    .setSslContext(sslContext).build();
//
//            // 🔐 Create Connection Manager with Registry
//            var connectionManager = org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder
//                    .create().setSSLSocketFactory(sslSocketFactory).build();
//
//            // 🔐 Build HttpClient
//            HttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
//
//            return new feign.hc5.ApacheHttp5Client(httpClient);
//
//        } catch (Exception e) {
//            throw new GrowxException("Failed to configure Feign mTLS", e);
//        }
//    }
//    
    @Bean
    public RequestInterceptor commontraceCorrelationInterceptorForCustomers() {
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
