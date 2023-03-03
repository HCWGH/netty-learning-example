package com.sanshengshui.netty.command.impl;

import com.sanshengshui.netty.command.CommandHandle;
import com.sanshengshui.netty.message.req.LoginReq;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author HCW
 * @date 2023/3/3 15:08
 * @todo
 */
public class LoginCommandHandle implements CommandHandle {
    @Override
    public void execute(Scanner scanner, Channel channel) {
        System.out.println("Please enter userName:");
        String userName = scanner.nextLine();
        System.out.println("Please enter password:");
        String password = scanner.nextLine();
        LoginReq loginReq = new LoginReq();
        loginReq.setUserName(userName);
        loginReq.setPassword(password);
        channel.writeAndFlush(loginReq);
    }
}
