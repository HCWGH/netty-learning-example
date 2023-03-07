package com.sanshengshui.netty.message.res;

import com.sanshengshui.netty.model.CommandType;
import com.sanshengshui.netty.protocol.Packet;

import java.util.List;

/**
 * @author HCW
 * @date 2023/3/3 17:09
 * @todo
 */
public class CreateGroupRes extends Packet {
    private List<String> userNameList;
    private String groupId;
    private Boolean succeed;


    @Override
    public Byte getCommandType() {
        return CommandType.CREATE_GROUP_RESPONSE.getBytes();
    }

    public Boolean getSucceed() {
        return succeed;
    }

    public void setSucceed(Boolean succeed) {
        this.succeed = succeed;
    }

    public List<String> getUserNameList() {
        return userNameList;
    }

    public void setUserNameList(List<String> userNameList) {
        this.userNameList = userNameList;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
