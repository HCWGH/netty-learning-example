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
