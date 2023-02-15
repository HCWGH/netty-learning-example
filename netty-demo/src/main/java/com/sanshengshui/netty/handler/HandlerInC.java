package com.sanshengshui.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author HCW
 * @date 2023/2/14 19:19
 * @todo
 */
public class HandlerInC extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("进入处理逻辑HandlerInC------------inC");
        super.channelRead(ctx, msg);
    }
}
