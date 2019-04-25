package com.leisu.tianjian.controller;

import com.alibaba.fastjson.JSONObject;
import com.leisu.tianjian.service.ChargeTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chargeType")
public class ChargeTypeController {
    @RequestMapping("/getByType")
    public JSONObject getByChargeType(@RequestBody JSONObject req) {
        String type = (String) req.get("type");

        return (JSONObject) JSONObject.toJSON(chargeTypeService.getByChargeType(type));
    }

    @Autowired
    private ChargeTypeService chargeTypeService;

    private Logger logger = LoggerFactory.getLogger(ChargeTypeController.class);
}
