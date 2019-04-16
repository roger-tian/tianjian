package com.leisu.tianjian.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AreaModel {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSuperior() {
        return superior;
    }

    public void setSuperior(String superior) {
        this.superior = superior;
    }

    private Long id;
    private String area;
    private String superior;

    private static final Logger logger = LoggerFactory.getLogger(AreaModel.class);
}
