package com.leisu.tianjian.model;

public class OrderFormModel {
    public Long getId() {
        return id;
    }

    public String getUserFrom() {
        return userFrom;
    }

    public String getUserFromPhone() {
        return userFromPhone;
    }

    public String getUserTo() {
        return userTo;
    }

    public String getUserToPhone() {
        return userToPhone;
    }

    public String getOrderFrom() {
        return orderFrom;
    }

    public String getOrderTo() {
        return orderTo;
    }

    public String getWeight() {
        return weight;
    }

    public String getVolume() {
        return volume;
    }

    public String getFlag() {
        return flag;
    }

    public String getAmount() {
        return amount;
    }

    public String getCtime() {
        return ctime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }

    public void setUserFromPhone(String userFromPhone) {
        this.userFromPhone = userFromPhone;
    }

    public void setUserTo(String userTo) {
        this.userTo = userTo;
    }

    public void setUserToPhone(String userToPhone) {
        this.userToPhone = userToPhone;
    }

    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom;
    }

    public void setOrderTo(String orderTo) {
        this.orderTo = orderTo;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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
