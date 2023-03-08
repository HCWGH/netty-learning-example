package com.sanshengshui.netty.command.impl;

import com.sanshengshui.netty.command.CommandHandle;
import com.sanshengshui.netty.message.req.ListGroupReq;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author HCW
 * @date 2023/3/8 14:53
 * @todo
 */
public class ListGroupMemberHandle implements CommandHandle {
    @Override
    public void execute(Scanner scanner, Channel channel) {
        System.out.println("Please enter view groupId:");
        String groupId = scanner.nextLine();
        ListGroupReq groupReq = new ListGroupReq();
        groupReq.setGroupId(groupId);
        channel.writeAndFlush(groupReq);
    }
}
