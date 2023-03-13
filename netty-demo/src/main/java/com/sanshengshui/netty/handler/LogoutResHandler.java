package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.message.res.LogoutRes;
import com.sanshengshui.netty.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author HCW
 * @date 2023/3/6 19:22
 * @todo
 */
@ChannelHandler.Sharable
public class LogoutResHandler extends SimpleChannelInboundHandler<LogoutRes> {
    public static final LogoutResHandler INSTANCE = new LogoutResHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutRes msg) throws Exception {
        System.out.println("Logout result:" + msg.getMsg());
        if (msg.isRes()) {
            SessionUtil.unBindSession(ctx.channel());
            ctx.channel().close();
        }
    }
}
