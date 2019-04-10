package com.qianfeng.fxmall.User.VO;

public class UserInfoVO {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "UserInfoVO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
