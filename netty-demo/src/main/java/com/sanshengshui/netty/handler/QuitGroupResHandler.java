package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.message.res.QuitGroupRes;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author HCW
 * @date 2023/3/8 16:13
 * @todo
 */
public class QuitGroupResHandler extends SimpleChannelInboundHandler<QuitGroupRes> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupRes msg) throws Exception {
        System.out.println(msg.getMsg());
    }
}
