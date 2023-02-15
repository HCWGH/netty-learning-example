package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.message.req.LoginReq;
import com.sanshengshui.netty.message.res.LoinRes;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author HCW
 * @date 2023/2/15 19:15
 * @todo 根据泛型处理登录请求
 */
public class MyLoginSimpleChannelHandler extends SimpleChannelInboundHandler<LoginReq> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoginReq loginReq) throws Exception {
        String userName = loginReq.getUserName();
        String password = loginReq.getPassword();
        System.out.println("================User login information " + userName + "|" + password + "=================");
        //response message
        LoinRes loinRes = new LoinRes();
        String response = "Hello ," + userName + " welcome to our service";
        loinRes.setSuccessful(true);
        loinRes.setResponseMes(response);
        //ByteBuf encode = PacketCodec.encode(loinRes);
        channelHandlerContext.channel().writeAndFlush(loinRes);
    }
}
