package com.leisu.tianjian.service;

public interface RedisService {
    boolean hasKey(String key);

    String get(String key);

    boolean set(String key, String value);

    boolean expire(String key, long expire);

    boolean remove(String key);
}
