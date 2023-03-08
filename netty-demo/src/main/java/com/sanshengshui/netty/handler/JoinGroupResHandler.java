package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.message.res.JoinGroupRes;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author HCW
 * @date 2023/3/8 15:16
 * @todo
 */
public class JoinGroupResHandler extends SimpleChannelInboundHandler<JoinGroupRes> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupRes msg) throws Exception {
        System.out.println(msg.getMsg());
    }
}
