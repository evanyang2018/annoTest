package com.example.demo;

/**
 * @Author: Evan Yang
 * @Description:
 * @Date: Create in 11:43 2018/7/7
 * @Modificd By:
 */
public class Users {

    /** 主键 */
    private String id;
    /** 用户名 */
    private String userName;
    /** 密码 */
    private String  password;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
