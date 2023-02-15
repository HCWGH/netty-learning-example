package com.sanshengshui.netty.client.handler;

import com.sanshengshui.netty.edcoding.PacketCodec;
import com.sanshengshui.netty.message.req.LoginReq;
import com.sanshengshui.netty.message.res.LoinRes;
import com.sanshengshui.netty.message.res.MessageRes;
import com.sanshengshui.netty.protocol.Packet;
import com.sanshengshui.netty.util.LoginUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author HCW
 * @date 2023/2/8 19:11
 * @todo 客户端处理逻辑
 */
public class ClientBaseHandler extends ChannelInboundHandlerAdapter {
    /**
     * 连接上服务器时处理逻辑
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("================The client connects to the server and prepares to log in===================");
        LoginReq loginReq = new LoginReq();
        loginReq.setUserName("1E7753");
        loginReq.setPassword("my_name_is_1E7753");
        //编码
        ByteBuf byteBuf = PacketCodec.encode(loginReq);
        ctx.channel().writeAndFlush(byteBuf);
    }

    /**
     * 收到服务器 respone
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("===================A response message was received from the server=========================");
        ByteBuf byteBuf = (ByteBuf) msg;
        Packet packet = PacketCodec.decode(byteBuf);
        if (packet instanceof LoinRes) {
            LoinRes res = (LoinRes) packet;
            if (res.getSuccessful()) {
                System.out.println("service response message :" + res + "\n" + "Login success!!!");
                LoginUtil.markLogin(ctx.channel());
            } else {
                System.out.println("service response message :" + res + "\n" + "Login failure!!!");
            }
        } else {
            if (packet instanceof MessageRes) {
                MessageRes res = (MessageRes) packet;
                String message = res.getMessage();
                System.out.println("server response message >>>>>>>>>>" + message);
            }
            //System.out.println("==========================To do other something========================");
        }
    }
}
