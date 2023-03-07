package com.sanshengshui.netty.message.req;

import com.sanshengshui.netty.model.CommandType;
import com.sanshengshui.netty.protocol.Packet;

/**
 * @author HCW
 * @date 2023/3/6 17:52
 * @todo
 */
public class LogoutReq extends Packet {
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public Byte getCommandType() {
        return CommandType.LOGOUT_REQUEST.getBytes();
    }
}
