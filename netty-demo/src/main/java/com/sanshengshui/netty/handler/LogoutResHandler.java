package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.message.res.LogoutRes;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author HCW
 * @date 2023/3/6 19:22
 * @todo
 */
public class LogoutResHandler extends SimpleChannelInboundHandler<LogoutRes> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutRes msg) throws Exception {
        System.out.println("Logout result:" + msg.getMsg());
    }
}
