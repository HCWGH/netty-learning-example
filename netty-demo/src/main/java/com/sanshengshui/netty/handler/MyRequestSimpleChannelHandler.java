package com.sanshengshui.netty.handler;


import com.sanshengshui.netty.message.req.MessageReq;
import com.sanshengshui.netty.message.res.MessageRes;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author HCW
 * @date 2023/2/15 19:18
 * @todo 根据泛型处理消息发送请求
 */
public class MyRequestSimpleChannelHandler extends SimpleChannelInboundHandler<MessageReq> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageReq messageReq) throws Exception {
        String message = messageReq.getMessage();
        System.out.println("client request message: " + message);
        String resMessage = "do you say :" + message;
        MessageRes res = new MessageRes();
        res.setMessage(resMessage);
        //ByteBuf encode = PacketCodec.encode(res);
        channelHandlerContext.channel().writeAndFlush(res);
    }

}
