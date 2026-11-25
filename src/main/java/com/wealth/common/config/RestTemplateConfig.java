package com.wealth.common.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Configuration
public class RestTemplateConfig {
	@Value("${resttemplate.connect.timeout}")
	private int restTemplateConnectTimeout;

	@Value("${resttemplate.read.timeout}")
	private int restTemplateReadTimeout;

	@Bean(name = "timeoutRestTemplate")
	RestTemplate timeoutRestTemplate() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setConnectTimeout(restTemplateConnectTimeout);
		factory.setReadTimeout(restTemplateReadTimeout);
		return new RestTemplate(factory);
	}

	@Bean(name = "defaultRestTemplate")
	public RestTemplate defaultRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();

		// Create a custom ObjectMapper that strips invalid null characters
		ObjectMapper mapper = new ObjectMapper();
		SimpleModule module = new SimpleModule();

		module.addSerializer(String.class, new JsonSerializer<String>() {
			@Override
			public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
				if (value != null) {
					// remove null characters from every string value
					gen.writeString(value.replace("\u0000", ""));
				} else {
					gen.writeNull();
				}
			}
		});

		mapper.registerModule(module);

		// Replace default Jackson converter with this custom mapper
		restTemplate.getMessageConverters().stream().filter(MappingJackson2HttpMessageConverter.class::isInstance)
				.findFirst().ifPresent(conv -> ((MappingJackson2HttpMessageConverter) conv).setObjectMapper(mapper));

		return restTemplate;
	}
}
