package com.leisu.tianjian.controller;

import com.alibaba.fastjson.JSONObject;
import com.leisu.tianjian.model.AreaModel;
import com.leisu.tianjian.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/area")
public class AreaController {
    @RequestMapping("/getProvince")
    public List<String> getProvince() {
        return areaService.getProvince();
    }

    @RequestMapping("/getCity")
    public List<String> getCity(@RequestBody JSONObject req) {
        String province = (String) req.get("province");

        return areaService.getCity(province);
    }

    @RequestMapping("getArea")
    public List<String> getArea(@RequestBody JSONObject req) {
        String province = (String) req.get("province");
        String city = (String) req.get("city");

        AreaModel areaModel = new AreaModel();
        areaModel.setProvince(province);
        areaModel.setCity(city);

        return areaService.getArea(areaModel);
    }

    @Autowired
    private AreaService areaService;

    private static final Logger logger = LoggerFactory.getLogger(AreaController.class);
}
