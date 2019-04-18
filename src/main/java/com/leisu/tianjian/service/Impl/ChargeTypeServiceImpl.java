package com.leisu.tianjian.service.Impl;

import com.leisu.tianjian.dao.ChargeTypeDao;
import com.leisu.tianjian.model.ChargeTypeModel;
import com.leisu.tianjian.service.ChargeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChargeTypeServiceImpl implements ChargeTypeService {
    @Override
    public ChargeTypeModel getByChargeType(String type) {
        return chargeTypeDao.getByChargeType(type);
    }

    @Autowired
    private ChargeTypeDao chargeTypeDao;
}
