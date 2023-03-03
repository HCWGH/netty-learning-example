package com.sanshengshui.netty.message.req;

import com.sanshengshui.netty.protocol.Packet;

import java.util.List;

/**
 * @author HCW
 * @date 2023/3/3 15:54
 * @todo
 */
public class CreateGroupReq extends Packet {
    private List<String> userIdList;

    @Override
    public Byte getCommandType() {
        return null;
    }

    public CreateGroupReq() {
    }

    public CreateGroupReq(List<String> userIdList) {
        this.userIdList = userIdList;
    }

    public List<String> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<String> userIdList) {
        this.userIdList = userIdList;
    }
}
