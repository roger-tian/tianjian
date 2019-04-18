package com.leisu.tianjian.dao;

import com.leisu.tianjian.model.ChargeTypeModel;

public interface ChargeTypeDao {
    ChargeTypeModel getByChargeType(String type);
}
