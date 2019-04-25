package com.leisu.tianjian.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.leisu.tianjian.dao.AreaDao;
import com.leisu.tianjian.dao.BaseChargeDao;
import com.leisu.tianjian.model.AreaModel;
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
    public List<HashMap> getAll() {
        return baseChargeDao.getAll();
    }

    @Override
    public String getByProvinceCityArea(AreaModel areaModel) {
        return baseChargeDao.getByProvinceCityArea(areaModel);
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
    public JSONObject excelBatchImport(File file) throws Exception {
        JSONObject jsonObject = new JSONObject();
        String result = "SUCCESS";
        String fileName = file.getName();
        logger.debug("------fileName: {}", fileName);

        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            result = "上传文件格式不正确";
            jsonObject.put("result", result);
            return jsonObject;
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

        String[] rowData = {"province", "city", "area", "charge"};

        for (int i=0; i<sheet.getLastRowNum()+1; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }

            Cell cell;
            for (int j=0; j<rowData.length; j++) {
                cell = row.getCell(j);
                logger.debug("cell: {}-{}", j, cell);
                if (cell != null) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    rowData[j] = cell.getStringCellValue();
                } else {
                    rowData[j] = "";
                    continue;
                }
            }

            if (((rowData[0]==null) && (rowData[1]==null) && (rowData[2]==null)) || (rowData[3]==null)) {
                continue;
            }

            AreaModel areaModel = new AreaModel();
            areaModel.setProvince(rowData[0]);
            areaModel.setCity(rowData[1]);
            areaModel.setArea(rowData[2]);

            AreaModel areaModelResult = areaDao.getByProvinceCityArea(areaModel);
            if (areaModelResult == null) {
                areaDao.insert(areaModel);
            } else {
                logger.debug("insert into area failed, data already exist");
                continue;
            }

            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("province", rowData[0]);
            hashMap.put("city", rowData[1]);
            hashMap.put("area", rowData[2]);
            hashMap.put("charge", rowData[3]);
            String charge = baseChargeDao.getByProvinceCityArea(areaModel);
            if ((charge == null) || charge.equals("")) {
                baseChargeDao.insertByArea(hashMap);
            } else {
                logger.debug("insert into base_charge failed, data already exist");
                continue;
            }
        }

        jsonObject.put("result", result);

        return jsonObject;
    }

    @Autowired
    private AreaDao areaDao;
    @Autowired
    private BaseChargeDao baseChargeDao;

    private static final Logger logger = LoggerFactory.getLogger(BaseChargeServiceImpl.class);
}
