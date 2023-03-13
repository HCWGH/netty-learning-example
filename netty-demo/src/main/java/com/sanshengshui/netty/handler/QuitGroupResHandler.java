package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.message.res.QuitGroupRes;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author HCW
 * @date 2023/3/8 16:13
 * @todo
 */
@ChannelHandler.Sharable
public class QuitGroupResHandler extends SimpleChannelInboundHandler<QuitGroupRes> {
    public static final QuitGroupResHandler INSTANCE = new QuitGroupResHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupRes msg) throws Exception {
        System.out.println(msg.getMsg());
    }
}
