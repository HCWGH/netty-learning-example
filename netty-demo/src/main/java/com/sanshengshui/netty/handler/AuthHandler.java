package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.util.LoginUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author HCW
 * @date 2023/3/6 20:00
 * @todo
 */
public class AuthHandler extends ChannelInboundHandlerAdapter {
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
