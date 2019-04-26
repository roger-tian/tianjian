package com.leisu.tianjian.controller;

import com.alibaba.fastjson.JSONObject;
import com.leisu.tianjian.model.UserModel;
import com.leisu.tianjian.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    JSONObject userLogin(@RequestBody JSONObject req) {
        JSONObject jsonResult = new JSONObject();

        String userName = req.getString("userName");
        String password = req.getString("password");

        UserModel userModel = userService.getUserByName(userName);
        logger.debug("user: {}-{}-{}", userModel, userName, password);
        if (userModel != null) {
            if (userName.equals(userModel.getUser()) && password.equals(userModel.getPassword())) {
                jsonResult.put("result", "SUCCESS");
            } else {
                jsonResult.put("result", "FAIL");
            }
        } else {
            jsonResult.put("result", "FAIL");
        }

        logger.debug("jsonResult: {}", jsonResult);

        return jsonResult;
    }

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
}
