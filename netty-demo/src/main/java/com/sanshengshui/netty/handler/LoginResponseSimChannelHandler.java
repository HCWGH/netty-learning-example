package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.edcoding.PacketCodec;
import com.sanshengshui.netty.message.req.LoginReq;
import com.sanshengshui.netty.message.res.LoinRes;
import com.sanshengshui.netty.util.LoginUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author HCW
 * @date 2023/2/15 19:21
 * @todo 客户端处理登录请求响应消息
 */
public class LoginResponseSimChannelHandler extends SimpleChannelInboundHandler<LoinRes> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoinRes loinRes) throws Exception {
        if (loinRes.getSuccessful()) {
            System.out.println("service response message :" + loinRes + "\n" + "Login success!!!");
            LoginUtil.markLogin(channelHandlerContext.channel());
        } else {
            System.out.println("service response message :" + loinRes + "\n" + "Login failure!!!");
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("================The client connects to the server and prepares to log in===================");
        LoginReq loginReq = new LoginReq();
        loginReq.setUserName("1E7753");
        loginReq.setPassword("my_name_is_1E7753");
        //编码
        ByteBuf byteBuf = PacketCodec.encode(loginReq);
        ctx.channel().writeAndFlush(byteBuf);
        super.channelActive(ctx);
    }
}
