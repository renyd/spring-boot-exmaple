package com.example.domain;

/**
 * Created by Domg on 2016/11/19.
 */
public class User extends BaseModel {

    private String userName;

    private Integer age;

    private Byte state;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}
