package com.sanshengshui.netty.command.impl;

import com.sanshengshui.netty.command.CommandHandle;
import com.sanshengshui.netty.message.req.LogoutReq;
import com.sanshengshui.netty.model.AttriButes;
import com.sanshengshui.netty.model.UserSession;
import com.sanshengshui.netty.util.SessionUtil;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author HCW
 * @date 2023/3/3 15:09
 * @todo
 */
public class LogoutCommandHandle implements CommandHandle {
    @Override
    public void execute(Scanner scanner, Channel channel) {
        UserSession userSession = channel.attr(AttriButes.USER_SESSION).get();
        if (userSession != null) {
            LogoutReq logoutReq = new LogoutReq();
            logoutReq.setUserId(userSession.getUserId());
            channel.writeAndFlush(logoutReq);
        }
    }
}
