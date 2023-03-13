package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.message.res.MessageRes;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author HCW
 * @date 2023/3/6 19:50
 * @todo
 */
@ChannelHandler.Sharable
public class PointToPointResHandler extends SimpleChannelInboundHandler<MessageRes> {
    public static final PointToPointResHandler INSTANCE = new PointToPointResHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRes msg) throws Exception {
        String userId = msg.getSendUser();
        String sendUserName = msg.getSendUserName();
        String message = msg.getMessage();
        System.out.println(sendUserName + "|" + userId + " has sent you a message:\n" + message);
    }
}
