package com.leisu.tianjian.dao;

import com.leisu.tianjian.model.BaseChargeModel;

import java.util.HashMap;
import java.util.List;

public interface BaseChargeDao {
    String getBaseChargeByArea(String area);

    List<HashMap> getAll();

    void insertByArea(HashMap map);

    void insertByAreaId(BaseChargeModel baseChargeModel);
}
