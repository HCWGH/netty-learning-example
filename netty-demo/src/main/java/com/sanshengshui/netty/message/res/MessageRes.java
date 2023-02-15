package com.sanshengshui.netty.message.res;

import com.sanshengshui.netty.model.CommandType;
import com.sanshengshui.netty.protocol.Packet;

/**
 * @author HCW
 * @date 2023/2/13 17:41
 * @todo
 */
public class MessageRes extends Packet {
    private String message;
    private Boolean successful;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    @Override
    public Byte getCommandType() {
        return CommandType.MESSAGE_RESPONSE.getBytes();
    }
}
