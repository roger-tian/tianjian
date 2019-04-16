package com.leisu.tianjian.service.Impl;

import com.leisu.tianjian.dao.OrderFormDao;
import com.leisu.tianjian.model.OrderFormModel;
import com.leisu.tianjian.service.OrderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderFormServiceImpl implements OrderFormService {
    @Override
    public int insert(OrderFormModel orderFormModel) {
        return orderFormDao.insert(orderFormModel);
    }

    @Autowired
    private OrderFormDao orderFormDao;
}
