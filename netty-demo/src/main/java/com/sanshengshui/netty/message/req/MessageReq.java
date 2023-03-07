package com.sanshengshui.netty.message.req;

import com.sanshengshui.netty.model.CommandType;
import com.sanshengshui.netty.protocol.Packet;

/**
 * @author HCW
 * @date 2023/2/13 17:40
 * @todo
 */
public class MessageReq extends Packet {
    private String message;
    private String receiver;

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Byte getCommandType() {
        return CommandType.MESSAGE_REQUEST.getBytes();
    }
}
