package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.util.LoginUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author HCW
 * @date 2023/3/6 20:00
 * @todo
 */
@ChannelHandler.Sharable
public class AuthHandler extends ChannelInboundHandlerAdapter {
    public final static AuthHandler INSTANCE = new AuthHandler();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Channel channel = ctx.channel();
        if (!LoginUtil.hasLogin(channel)) {
            channel.close();
        } else {
            //移除当前handler
            channel.pipeline().remove(this);
            super.channelRead(ctx, msg);
        }
    }
}
