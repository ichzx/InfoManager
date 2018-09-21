package com.reed.InfoManager.model;

/**
 * 用户类包括id,用户名，密码
 * 电话号码，地址和用户介绍
 */
public class User {
    private int id;

    private String username;

    private String password;

    private String phone;

    private String address;

    private String info;

    public User(){
    }
    /**
     * 构造方法
     * @param username
     * @param password
     * @param phone
     * @param address
     * @param info
     */
    public User(int id, String username, String password, String phone, String address, String info) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.info = info;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getId(){
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getInfo() {
        return info;
    }
}
