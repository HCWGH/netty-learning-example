package com.sanshengshui.netty.message.res;

import com.sanshengshui.netty.model.CommandType;
import com.sanshengshui.netty.protocol.Packet;

/**
 * @author HCW
 * @date 2023/3/8 15:55
 * @todo
 */
public class QuitGroupRes extends Packet {
    private boolean res;
    private String msg;

    public boolean isRes() {
        return res;
    }

    public void setRes(boolean res) {
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
        return CommandType.QUIT_GROUP_RESPONSE.getBytes();
    }
}
