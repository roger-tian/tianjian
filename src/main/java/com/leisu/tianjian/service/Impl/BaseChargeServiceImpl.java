package com.leisu.tianjian.service.Impl;

import com.leisu.tianjian.dao.BaseChargeDao;
import com.leisu.tianjian.service.BaseChargeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseChargeServiceImpl implements BaseChargeService {
    @Override
    public String getBaseChargeByArea(String area) {
        return baseChargeDao.getBaseChargeByArea(area);
    }

    @Autowired
    private BaseChargeDao baseChargeDao;

    private static final Logger logger = LoggerFactory.getLogger(BaseChargeServiceImpl.class);
}
