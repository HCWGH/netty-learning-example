package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.message.res.ListGroupRes;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author HCW
 * @date 2023/3/8 15:50
 * @todo
 */
public class ListGroupResHandler extends SimpleChannelInboundHandler<ListGroupRes> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupRes msg) throws Exception {
        System.out.println(msg.getMsg());
    }
}
