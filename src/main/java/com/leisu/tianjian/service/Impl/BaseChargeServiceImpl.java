package com.leisu.tianjian.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.leisu.tianjian.dao.BaseChargeDao;
import com.leisu.tianjian.model.BaseChargeModel;
import com.leisu.tianjian.service.BaseChargeService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

@Service
public class BaseChargeServiceImpl implements BaseChargeService {
    @Override
    public String getBaseChargeByArea(String area) {
        return baseChargeDao.getBaseChargeByArea(area);
    }

    @Override
    public List<HashMap> getAll() {
        return baseChargeDao.getAll();
    }

    @Override
    public void insertByArea(HashMap map) {
        baseChargeDao.insertByArea(map);
    }

    @Override
    public void insertByAreaId(BaseChargeModel baseChargeModel) {
        baseChargeDao.insertByAreaId(baseChargeModel);
    }

    @Override
    public String excelBatchImport(File file) throws Exception {
        String result = "SUCCESS";
        String fileName = file.getName();
        logger.debug("------fileName: {}", fileName);

        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            result = "上传文件格式不正确";
            return result;
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = new FileInputStream(file);
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        logger.debug("{}", sheet.getLastRowNum());
        for (int r=0; r<sheet.getLastRowNum()+1; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }

            row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
            String area = row.getCell(0).getStringCellValue();

            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
            String charge = row.getCell(1).getStringCellValue();

            if (area == null || charge == null) {
                continue;
            }

            HashMap hashMap = new HashMap<String, String>();
            hashMap.put("area", area);
            hashMap.put("charge", charge);
            baseChargeDao.insertByArea(hashMap);
        }

        return result;
    }

    @Autowired
    private BaseChargeDao baseChargeDao;

    private static final Logger logger = LoggerFactory.getLogger(BaseChargeServiceImpl.class);
}
