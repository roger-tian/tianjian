package com.leisu.tianjian.service.Impl;

import com.leisu.tianjian.dao.AreaDao;
import com.leisu.tianjian.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Override
    public List<String> getProvince() {
        return areaDao.getProvince();
    }

    @Override
    public List<String> getCity(String superior) {
        return areaDao.getCity(superior);
    }

    @Autowired
    private AreaDao areaDao;
    @Resource(name="tjRedisTemplate")
    private RedisTemplate<Object, Object> tjRedisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(AreaServiceImpl.class);
}
