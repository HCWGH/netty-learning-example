package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.message.res.MessageRes;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author HCW
 * @date 2023/3/6 19:50
 * @todo
 */
public class PointToPointResHandler extends SimpleChannelInboundHandler<MessageRes> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRes msg) throws Exception {
        String sendUser = msg.getSendUser();
        String sendUserName = msg.getSendUserName();
        String message = msg.getMessage();
        System.out.println(sendUserName + " has sent you a message:\n" + message);
    }
}
