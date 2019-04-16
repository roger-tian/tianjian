package com.leisu.tianjian;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@MapperScan("com.leisu.tianjian.dao")
public class TianjianApplication {
    public static void main(String[] args) {
        SpringApplication.run(TianjianApplication.class, args);
    }

    @Bean("tjRedisTemplate")
    public RedisTemplate<Object, Object> tjRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        logger.debug("template: {}", template);
        return template;
    }

    private static final Logger logger = LoggerFactory.getLogger(TianjianApplication.class);
}
