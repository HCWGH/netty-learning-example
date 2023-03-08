package com.sanshengshui.netty.message.res;

import com.sanshengshui.netty.model.CommandType;
import com.sanshengshui.netty.protocol.Packet;

/**
 * @author HCW
 * @date 2023/3/8 14:57
 * @todo
 */
public class JoinGroupRes extends Packet {
    private Boolean res;
    private String msg;

    public Boolean getRes() {
        return res;
    }

    public void setRes(Boolean res) {
        this.res = res;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public Byte getCommandType() {
        return CommandType.JOIN_GROUP_RESPONSE.getBytes();
    }
}
