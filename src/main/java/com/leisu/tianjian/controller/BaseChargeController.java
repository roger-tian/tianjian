package com.leisu.tianjian.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.leisu.tianjian.service.BaseChargeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/baseCharge")
public class BaseChargeController {
    @RequestMapping("/getByArea")
    public String getBaseChargeByArea(@RequestBody Map req) {
        String province = (String) req.get("province");
        String city = (String) req.get("city");
        String area;
        if (city.equals("空")) {
            area = city;
        } else {
            area = province;
        }
        return baseChargeService.getBaseChargeByArea(area);
    }

    @RequestMapping("/excelImport")
    public String baseChargeExcelImport(MultipartFile file) throws Exception {
        String result = "SUCCESS";

        if (file == null) {
            return "FAIL";
        }

        String fileName = file.getOriginalFilename();
        String path = uploadPath + file.getOriginalFilename();
        logger.debug("path: {}", path);
        File fileServer = new File(path);
        file.transferTo(fileServer);

        baseChargeService.excelBatchImport(fileServer);

        return result;
    }

    @RequestMapping("/getAll")
    public JSONObject getAll(String pageNo) {
        JSONObject jsonObject = new JSONObject();

        List<HashMap> list = baseChargeService.getAll();
        int curRecord = (Integer.parseInt(pageNo) - 1) * 10;
        int totalPage = (list.size() - 1) / 10 + 1;
        JSONArray jsonArray = new JSONArray();
        for (int i=curRecord; i<curRecord+10; i++) {
            if (i >= list.size()) {
                break;
            }

            Map<String, String> map = new HashMap<>();
            String area = (String) list.get(i).get("area");
            map.put("area", area);
            if (list.get(i).containsKey("charge")) {
                String charge = list.get(i).get("charge").toString();
                map.put("charge", charge);
            } else {
                map.put("charge", "");
            }
            jsonArray.add(map);
        }

        jsonObject.put("list", jsonArray);
        jsonObject.put("totalPage", totalPage);
        jsonObject.put("result", "SUCCESS");

        logger.debug("baseCharge getAll: {}", list);

        return jsonObject;
    }

    @Autowired
    private BaseChargeService baseChargeService;
    @Value("${base-charge.upload-path}")
    private String uploadPath;

    private static final Logger logger = LoggerFactory.getLogger(BaseChargeController.class);
}
