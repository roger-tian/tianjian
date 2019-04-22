package com.leisu.tianjian.dao;

import com.leisu.tianjian.model.BaseChargeModel;

import java.util.HashMap;

public interface BaseChargeDao {
    String getBaseChargeByArea(String area);

    void insertByArea(HashMap map);

    void insertByAreaId(BaseChargeModel baseChargeModel);
}
