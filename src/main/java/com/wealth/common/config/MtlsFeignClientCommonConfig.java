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
import com.wealth.common.utils.generic.RequestHeaderUtil;

import feign.Client;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.codec.ErrorDecoder;
@Configuration
public class MtlsFeignClientCommonConfig {

    @Bean
    public ErrorDecoder errorCommonDecoder() {
        return new MyCustomErrorDecoder();
    }

    @Bean
    public RequestInterceptor commontraceCorrelationInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                // Reuse traceId from MDC if present
                String traceId = MDC.get("traceId");
                if (traceId != null) {
                    template.header("X-Trace-ID", traceId);
                }

                String correlationId = MDC.get("correlationId");
                if (correlationId == null) {
                    correlationId = java.util.UUID.randomUUID().toString();
                    MDC.put("correlationId", correlationId);
                }
                template.header("X-Correlation-ID", correlationId);
                if (!RequestHeaderUtil.isPublic()) {
                	   String appId = RequestHeaderUtil.getAppId();
                       if (appId != null && !appId.isEmpty()) {
                           template.header("X-App-ID", appId);
                       }
                       String usercode = RequestHeaderUtil.getUserCode();
                       if (usercode != null && !usercode.isEmpty()) {
                           template.header("X-USER-CODE", usercode);
                       }
				}
             
            }

		
        };
    }
    
}
