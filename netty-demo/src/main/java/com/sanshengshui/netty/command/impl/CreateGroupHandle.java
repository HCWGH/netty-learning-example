package com.sanshengshui.netty.command.impl;

import com.sanshengshui.netty.command.CommandHandle;
import com.sanshengshui.netty.message.req.CreateGroupReq;
import io.netty.channel.Channel;
import io.netty.util.internal.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author HCW
 * @date 2023/3/3 15:10
 * @todo
 */
public class CreateGroupHandle implements CommandHandle {
    @Override
    public void execute(Scanner scanner, Channel channel) {
        String userIds = null;
        while (StringUtil.isNullOrEmpty(userIds)) {
            System.out.println("Please enter the user id, separated by commas:");
            userIds = scanner.nextLine();
        }
        List<String> userIdList = Arrays.asList(userIds.split(","));
        CreateGroupReq createGroupReq = new CreateGroupReq(userIdList);
        channel.writeAndFlush(createGroupReq);
    }
}
