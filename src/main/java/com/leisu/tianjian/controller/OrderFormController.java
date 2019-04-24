package com.leisu.tianjian.controller;

import com.alibaba.fastjson.JSONObject;
import com.leisu.tianjian.model.OrderFormModel;
import com.leisu.tianjian.service.OrderFormService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderFormController {
    @RequestMapping("/generate")
    public JSONObject generateOrder(@RequestBody Map req) {
        String userFrom = (String) req.get("userFrom");
        String userFromPhone = (String) req.get("userFromPhone");
        String userTo = (String) req.get("userTo");
        String userToPhone = (String) req.get("userToPhone");
        String orderFrom = (String) req.get("orderFrom");
        String orderTo = (String) req.get("orderTo");
        String chargeType = (String) req.get("chargeType");
        String weight = (String) req.get("weight");
        String volume = (String) req.get("volume");
        String amount = (String) req.get("amount");

        JSONObject jsonObject = new JSONObject();

        OrderFormModel orderFormModel = new OrderFormModel();
        orderFormModel.setUserFrom(userFrom);
        orderFormModel.setUserFromPhone(userFromPhone);
        orderFormModel.setUserTo(userTo);
        orderFormModel.setUserToPhone(userToPhone);
        orderFormModel.setOrderFrom(orderFrom);
        orderFormModel.setOrderTo(orderTo);
        orderFormModel.setFlag(chargeType);
        orderFormModel.setWeight(weight);
        orderFormModel.setVolume(volume);
        orderFormModel.setAmount(amount);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        logger.debug("time: {}", time);
        orderFormModel.setCtime(time);

        orderFormService.insert(orderFormModel);

        jsonObject.put("result", "SUCCESS");

        return jsonObject;
    }

    @Autowired
    private OrderFormService orderFormService;

    private static final Logger logger = LoggerFactory.getLogger(OrderFormController.class);
}
