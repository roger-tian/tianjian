package com.leisu.tianjian.dao;

import com.leisu.tianjian.model.AreaModel;
import com.leisu.tianjian.model.BaseChargeModel;

import java.util.HashMap;
import java.util.List;

public interface BaseChargeDao {
    List<HashMap> getAll();

    String getByProvinceCityArea(AreaModel areaModel);

    void insertByArea(HashMap map);

    void insertByAreaId(BaseChargeModel baseChargeModel);
}
