package com.leisu.tianjian.model;

public class AreaModel {
    public Long getId() {
        return id;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getArea() {
        return area;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setArea(String area) {
        this.area = area;
    }

    private Long id;
    private String province;
    private String city;
    private String area;
}
