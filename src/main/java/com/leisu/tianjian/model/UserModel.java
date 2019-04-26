package com.leisu.tianjian.model;

public class UserModel {
    public Long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getCtime() {
        return ctime;
    }

    public String getLtime() {
        return ltime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public void setLtime(String ltime) {
        this.ltime = ltime;
    }

    private Long id;
    private String user;
    private String name;
    private String phone;
    private String password;
    private String role;
    private String ctime;
    private String ltime;
}
