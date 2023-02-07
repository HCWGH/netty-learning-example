package com.sanshengshui.netty.message.req;

import com.sanshengshui.netty.model.CommandType;
import com.sanshengshui.netty.protocol.Packet;

/**
 * @author HCW
 * @date 2023/2/7 14:58
 * @todo
 */
public class LoginReq extends Packet {
    private String userName;
    private String password;

    @Override
    public Byte getCommandType() {
        return CommandType.LOGIN_REQUEST.getBytes();
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
