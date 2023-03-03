package com.sanshengshui.netty.model;

/**
 * @author HCW
 * @date 2023/3/3 16:27
 * @todo
 */
public class UserSession {
    private String userName;
    private String userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
