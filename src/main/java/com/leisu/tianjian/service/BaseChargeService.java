package com.leisu.tianjian.service;

import com.alibaba.fastjson.JSONObject;
import com.leisu.tianjian.model.BaseChargeModel;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public interface BaseChargeService {
    String getBaseChargeByArea(String area);

    List<HashMap> getAll();

    void insertByArea(HashMap map);

    void insertByAreaId(BaseChargeModel baseChargeModel);

    String excelBatchImport(File file) throws Exception;
}
