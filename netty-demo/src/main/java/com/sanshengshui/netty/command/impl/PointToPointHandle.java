package com.sanshengshui.netty.command.impl;

import com.sanshengshui.netty.command.CommandHandle;
import com.sanshengshui.netty.message.req.MessageReq;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author HCW
 * @date 2023/3/3 15:14
 * @todo
 */
public class PointToPointHandle implements CommandHandle {
    @Override
    public void execute(Scanner scanner, Channel channel) {
        System.out.println("Please enter the receiver user:");
        String receiver = scanner.nextLine();
        System.out.println("Please enter a message:");
        String message = scanner.nextLine();
        MessageReq req = new MessageReq();
        req.setReceiver(receiver);
        req.setMessage(message);
        channel.writeAndFlush(req);
    }
}
