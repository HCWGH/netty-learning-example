package com.sanshengshui.netty.message.req;

import com.sanshengshui.netty.model.CommandType;
import com.sanshengshui.netty.protocol.Packet;

/**
 * @author HCW
 * @date 2023/3/8 15:54
 * @todo
 */
public class QuitGroupReq extends Packet {
    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public Byte getCommandType() {
        return CommandType.QUIT_GROUP_REQUEST.getBytes();
    }
}
