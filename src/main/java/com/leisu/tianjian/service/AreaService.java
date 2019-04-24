package com.leisu.tianjian.service;

import com.leisu.tianjian.model.AreaModel;

import java.util.List;

public interface AreaService {
    List<String> getProvince();

    List<String> getCity(String superior);

    List<String> getArea(AreaModel areaModel);
}
