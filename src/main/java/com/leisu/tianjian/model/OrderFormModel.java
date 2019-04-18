package com.leisu.tianjian.model;

public class OrderFormModel {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }

    public String getUserFromPhone() {
        return userFromPhone;
    }

    public void setUserFromPhone(String userFromPhone) {
        this.userFromPhone = userFromPhone;
    }

    public String getUserTo() {
        return userTo;
    }

    public void setUserTo(String userTo) {
        this.userTo = userTo;
    }

    public String getUserToPhone() {
        return userToPhone;
    }

    public void setUserToPhone(String userToPhone) {
        this.userToPhone = userToPhone;
    }

    public String getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom;
    }

    public String getOrderTo() {
        return orderTo;
    }

    public void setOrderTo(String orderTo) {
        this.orderTo = orderTo;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    private Long id;
    private String userFrom;
    private String userFromPhone;
    private String userTo;
    private String userToPhone;
    private String orderFrom;
    private String orderTo;
    private String weight;
    private String volume;
    private String flag;
    private String amount;
    private String ctime;
}
