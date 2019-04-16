package com.leisu.tianjian.dao;

import java.util.List;

public interface AreaDao {
    List<String> getProvince();

    List<String> getCity(String superior);
}
