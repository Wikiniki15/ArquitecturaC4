package com.consultaciudadano.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.CacheManager;

import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

@Configuration
@EnableCaching
public class RedisConfig {

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName("proper-ray-36374.upstash.io");
        config.setPort(6379);
        config.setPassword(RedisPassword.of("AY4WAAIjcDE1NDIxZGQ3NWMwNTY0ZTFjOGYwNDdkM2Q2NzZmMjVkNHAxMA")); // 👈 reemplaza esto con tu password real de Upstash

        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
                .useSsl() // Necesario para Upstash (TLS habilitado)
                .build();

        return new LettuceConnectionFactory(config, clientConfig);
    }

    @Bean
    public CacheManager cacheManager(LettuceConnectionFactory connectionFactory) {
        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(
                        RedisCacheConfiguration.defaultCacheConfig()
                                .serializeValuesWith(
                                        RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer())
                                )
                ).build();
    }
}
