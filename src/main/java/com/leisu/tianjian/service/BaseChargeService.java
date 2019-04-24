package com.leisu.tianjian.service;

import com.leisu.tianjian.model.AreaModel;
import com.leisu.tianjian.model.BaseChargeModel;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public interface BaseChargeService {
    List<HashMap> getAll();

    String getByProvinceCityArea(AreaModel areaModel);

    void insertByArea(HashMap map);

    void insertByAreaId(BaseChargeModel baseChargeModel);

    String excelBatchImport(File file) throws Exception;
}
