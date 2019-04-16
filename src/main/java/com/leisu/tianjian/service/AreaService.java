package com.leisu.tianjian.service;

import java.util.List;

public interface AreaService {
    List<String> getProvince();

    List<String> getCity(String superior);
}
