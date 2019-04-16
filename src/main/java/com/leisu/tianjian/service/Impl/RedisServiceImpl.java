package com.leisu.tianjian.service.Impl;

import com.leisu.tianjian.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service("redisService")
public class RedisServiceImpl implements RedisService {
    @Resource
    private RedisTemplate<String, ?> redisTemplate;

    @Override
    public boolean hasKey(String key) {
        logger.debug("hasKey: {}", key);
        return redisTemplate.hasKey(key);
    }

    @Override
    public String get(final String key) {
        String result = redisTemplate.execute((RedisCallback<String>) connection -> {
            RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
            byte[] value = connection.get(serializer.serialize(key));
            return serializer.deserialize(value);
        });

        return result;
    }

    @Override
    public boolean set(final String key, final String value) {
        boolean result = redisTemplate.execute((RedisCallback<Boolean>) connection -> {
            RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
            connection.set(serializer.serialize(key), serializer.serialize(value));
            redisTemplate.boundValueOps(key);
            return true;
        });

        return result;
    }

    @Override
    public boolean expire(final String key, long expire) {
        return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    @Override
    public boolean remove(final String key) {
        boolean result = redisTemplate.execute((RedisCallback<Boolean>) connection -> {
            connection.del(key.getBytes());
            return true;
        });

        return result;
    }

    private static final Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);
}
