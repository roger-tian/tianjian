package com.leisu.tianjian.controller;

import com.leisu.tianjian.model.OrderFormModel;
import com.leisu.tianjian.service.OrderFormService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderFormController {
    @RequestMapping("/generate")
    public String generateOrder(@RequestBody Map req) {
        String from = (String) req.get("from");
        String to = (String) req.get("to");
        String chargeType = (String) req.get("chargeType");
        String weight = (String) req.get("weight");
        String volume = (String) req.get("volume");
        String charge = (String) req.get("charge");

        OrderFormModel orderFormModel = new OrderFormModel();
        orderFormModel.setFrom(from);
        orderFormModel.setTo(to);
        orderFormModel.setFlag(chargeType);
        orderFormModel.setWeight(weight);
        orderFormModel.setVolume(volume);
        orderFormModel.setAmount(charge);

        orderFormService.insert(orderFormModel);

        return "";
    }

    @Autowired
    private OrderFormService orderFormService;

    private static final Logger logger = LoggerFactory.getLogger(OrderFormController.class);
}
