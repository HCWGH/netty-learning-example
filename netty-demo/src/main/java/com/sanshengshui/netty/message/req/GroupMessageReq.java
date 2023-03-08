package com.sanshengshui.netty.message.req;

import com.sanshengshui.netty.model.CommandType;
import com.sanshengshui.netty.protocol.Packet;

/**
 * @author HCW
 * @date 2023/3/8 19:41
 * @todo
 */
public class GroupMessageReq extends Packet {
    private String groupId;
    private String groupMessage;

    @Override
    public Byte getCommandType() {
        return CommandType.GROUP_MESSAGE_REQUEST.getBytes();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupMessage() {
        return groupMessage;
    }

    public void setGroupMessage(String groupMessage) {
        this.groupMessage = groupMessage;
    }
}
