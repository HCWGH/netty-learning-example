package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.message.res.MessageRes;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author HCW
 * @date 2023/2/15 19:24
 * @todo 客户端处理服务端响应消息
 */
@ChannelHandler.Sharable
public class MessageResponseSimpleChannelHandler extends SimpleChannelInboundHandler<MessageRes> {
    public static final MessageResponseSimpleChannelHandler INSTANCE = new MessageResponseSimpleChannelHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageRes messageRes) throws Exception {
        String message = messageRes.getMessage();
        System.out.println("server response message >>>>>>>>>>" + message);
    }
}
