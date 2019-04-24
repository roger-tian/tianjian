package com.leisu.tianjian.model;

public class BaseChargeModel {
    public Long getId() {
        return id;
    }

    public Long getAreaId() {
        return areaId;
    }

    public String getCharge() {
        return charge;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    private Long id;
    private Long areaId;
    private String charge;
}
