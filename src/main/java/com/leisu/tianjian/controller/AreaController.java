package com.leisu.tianjian.controller;

import com.leisu.tianjian.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/area")
public class AreaController {
    @RequestMapping("/getProvince")
    public List<String> getProvince() {
        return areaService.getProvince();
    }

    @RequestMapping("/getCity")
    public List<String> getCity(@RequestBody Map req) {
        String superior = (String) req.get("superior");
        logger.debug("getCity req: {}", req);

        return areaService.getCity(superior);
    }

    @Autowired
    private AreaService areaService;

    private static final Logger logger = LoggerFactory.getLogger(AreaController.class);
}
