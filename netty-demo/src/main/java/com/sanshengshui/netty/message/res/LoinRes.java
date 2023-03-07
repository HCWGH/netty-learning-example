package com.sanshengshui.netty.message.res;

import com.sanshengshui.netty.model.CommandType;
import com.sanshengshui.netty.protocol.Packet;

/**
 * @author HCW
 * @date 2023/2/8 19:39
 * @todo
 */
public class LoinRes extends Packet {
    private String responseMes;
    private Boolean isSuccessful;
    private String userId;
    private String userName;

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

    public Boolean getSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(Boolean successful) {
        isSuccessful = successful;
    }

    @Override
    public Byte getCommandType() {
        return CommandType.LOGIN_RESPONSE.getBytes();
    }

    public String getResponseMes() {
        return responseMes;
    }

    public void setResponseMes(String responseMes) {
        this.responseMes = responseMes;
    }
}
