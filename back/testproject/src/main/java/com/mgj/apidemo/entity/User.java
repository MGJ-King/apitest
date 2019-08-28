package com.mgj.apidemo.entity;

public class User {
    private String usercode;
    private String username;
    private String department;

    public User() {
    }

    public User(String usercode, String username, String department) {
        this.usercode = usercode;
        this.username = username;
        this.department = department;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "User{" +
                "usercode='" + usercode + '\'' +
                ", username='" + username + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
