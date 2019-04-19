package com.leisu.tianjian.controller;

import com.leisu.tianjian.service.BaseChargeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private BaseChargeService baseChargeService;

    private static final Logger logger = LoggerFactory.getLogger(BaseChargeController.class);
}
