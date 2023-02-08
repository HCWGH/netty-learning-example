package com.sanshengshui.netty.server.handler;


import com.sanshengshui.netty.edcoding.PacketCodec;
import com.sanshengshui.netty.message.req.LoginReq;
import com.sanshengshui.netty.message.res.LoinRes;
import com.sanshengshui.netty.protocol.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author HCW
 * @date 2023/2/8 19:51
 * @todo
 */
public class ServerBaseHandler extends ChannelInboundHandlerAdapter {
    /**
     * 客户端连接上服务器时的处理逻辑
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("======================= " + channel.remoteAddress().toString() + " The client is connected to the server. Procedure ");
    }

    /**
     * 接收到客户端请求消息时的处理逻辑
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        Packet packet = PacketCodec.decode(byteBuf);
        if (packet instanceof LoginReq) {
            LoginReq req = (LoginReq) packet;
            String userName = req.getUserName();
            String password = req.getPassword();
            System.out.println("================User login information " + userName + "|" + password + "=================");
            //response message
            LoinRes loinRes = new LoinRes();
            String response = "Hello ," + userName + " welcome to our service";
            loinRes.setResponseMes(response);
            ByteBuf encode = PacketCodec.encode(loinRes);
            ctx.channel().writeAndFlush(encode);
        } else {
            System.out.println("====================What should we do==============");
        }
    }
}
