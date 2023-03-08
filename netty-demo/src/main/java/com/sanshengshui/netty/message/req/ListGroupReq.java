package com.sanshengshui.netty.message.req;

import com.sanshengshui.netty.model.CommandType;
import com.sanshengshui.netty.protocol.Packet;

/**
 * @author HCW
 * @date 2023/3/8 15:22
 * @todo
 */
public class ListGroupReq extends Packet {
    private String groupId;

    @Override
    public Byte getCommandType() {
        return CommandType.LIST_GROUP_REQUEST.getBytes();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
