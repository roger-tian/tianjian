package com.leisu.tianjian.dao;

import com.leisu.tianjian.model.AreaModel;

import java.util.List;

public interface AreaDao {
    List<String> getProvince();

    List<String> getCity(String province);

    List<String> getArea(AreaModel areaModel);
}
