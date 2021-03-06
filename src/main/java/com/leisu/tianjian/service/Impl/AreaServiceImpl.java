package com.leisu.tianjian.service.Impl;

import com.leisu.tianjian.dao.AreaDao;
import com.leisu.tianjian.model.AreaModel;
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

    @Override
    public List<String> getArea(AreaModel areaModel) {
        return areaDao.getArea(areaModel);
    }

    @Override
    public AreaModel getByProvinceCityArea(AreaModel areaModel) {
        return areaDao.getByProvinceCityArea(areaModel);
    }

    @Override
    public void insert(AreaModel areaModel) {
        areaDao.insert(areaModel);
    }

    @Autowired
    private AreaDao areaDao;
    @Resource(name="tjRedisTemplate")
    private RedisTemplate<Object, Object> tjRedisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(AreaServiceImpl.class);
}
