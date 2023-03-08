package com.sanshengshui.netty.command.impl;

import com.sanshengshui.netty.command.CommandHandle;
import com.sanshengshui.netty.message.req.GroupMessageReq;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author HCW
 * @date 2023/3/8 19:38
 * @todo
 */
public class GroupMessageHandle implements CommandHandle {
    @Override
    public void execute(Scanner scanner, Channel channel) {
        System.out.println("Please enter groupId:");
        String groupId = scanner.nextLine();
        System.out.println("Please enter a group message:");
        String groupMessage = scanner.nextLine();
        GroupMessageReq messageReq = new GroupMessageReq();
        messageReq.setGroupId(groupId);
        messageReq.setGroupMessage(groupMessage);
        channel.writeAndFlush(messageReq);
    }
}
