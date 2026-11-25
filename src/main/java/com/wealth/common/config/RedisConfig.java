//package com.wealth.common.config;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Configuration
//@EnableCaching
//public class RedisConfig {
//
//	@Bean
//	public RedisConnectionFactory redisConnectionFactory() {
//		return new LettuceConnectionFactory();
//	}
//
//	@Bean
//	@Primary
//	public ObjectMapper httpObjectMapper() {
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//		return mapper;
//	}
//
//	@Bean(name = "redisObjectMapper")
//	public ObjectMapper redisObjectMapper() {
//	    ObjectMapper mapper = new ObjectMapper();
//	    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//	    return mapper;
//	}
//
//	@Bean
//	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory,
//			@Qualifier("redisObjectMapper") ObjectMapper redisObjectMapper) {
//		GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer(redisObjectMapper);
//		RedisTemplate<String, Object> template = new RedisTemplate<>();
//		template.setConnectionFactory(factory);
//		template.setKeySerializer(new StringRedisSerializer());
//		template.setValueSerializer(serializer);
//		template.setHashKeySerializer(new StringRedisSerializer());
//		template.setHashValueSerializer(serializer);
//		template.afterPropertiesSet();
//		return template;
//	}
//
//	@Bean
//	public RedisCacheManager cacheManager(RedisConnectionFactory factory,
//			@Qualifier("redisObjectMapper") ObjectMapper redisObjectMapper) {
//		GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer(redisObjectMapper);
//		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
//				.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));
//		return RedisCacheManager.builder(factory).cacheDefaults(config).build();
//	}
//
//}
