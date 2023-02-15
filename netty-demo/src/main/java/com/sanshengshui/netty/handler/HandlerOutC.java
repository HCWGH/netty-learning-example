package com.sanshengshui.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * @author HCW
 * @date 2023/2/14 19:23
 * @todo
 */
public class HandlerOutC extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("进入处理逻辑HandlerOutC-----------outC");
        super.write(ctx, msg, promise);
    }
}
