package com.sanshengshui.netty.command.impl;

import com.sanshengshui.netty.command.CommandHandle;
import com.sanshengshui.netty.message.req.JoinGroupReq;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author HCW
 * @date 2023/3/8 14:49
 * @todo
 */
public class JoinGroupHandle implements CommandHandle {
    @Override
    public void execute(Scanner scanner, Channel channel) {
        System.out.println("Please enter groupId:");
        String groupId = scanner.nextLine();
        JoinGroupReq groupReq = new JoinGroupReq();
        groupReq.setGroupId(groupId);
        channel.writeAndFlush(groupReq);
    }
}
