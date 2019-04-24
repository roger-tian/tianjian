package com.leisu.tianjian.model;

public class ChargeTypeModel {
    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getCharge() {
        return charge;
    }

    public String getRemark() {
        return remark;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    private Long id;
    private String type;
    private String charge;
    private String remark;
}
