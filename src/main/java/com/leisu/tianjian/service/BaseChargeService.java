package com.leisu.tianjian.service;

import com.leisu.tianjian.model.BaseChargeModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;

public interface BaseChargeService {
    String getBaseChargeByArea(String area);

    void insertByArea(HashMap map);

    void insertByAreaId(BaseChargeModel baseChargeModel);

    String excelBatchImport(File file) throws Exception;
}
