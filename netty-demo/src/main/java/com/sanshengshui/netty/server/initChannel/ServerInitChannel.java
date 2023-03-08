package com.sanshengshui.netty.server.initChannel;

import com.sanshengshui.netty.edcoding.PacketDecoder;
import com.sanshengshui.netty.edcoding.PacketEncoding;
import com.sanshengshui.netty.handler.*;
import com.sanshengshui.netty.server.handler.ServerBaseHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author HCW
 * @date 2023/2/6 17:41
 * @todo
 */
public class ServerInitChannel extends ChannelInitializer<NioSocketChannel> {
    private final static ServerBaseHandler SERVER_BASE_HANDLER = new ServerBaseHandler();

    @Override
    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
        ChannelPipeline pipeline = nioSocketChannel.pipeline();
//        pipeline.addLast(new HandlerInA());
//        pipeline.addLast(new HandlerInB());
//        pipeline.addLast(new HandlerInC());
//        pipeline.addLast(SERVER_BASE_HANDLER);
//        pipeline.addLast(new HandlerOutA());
//        pipeline.addLast(new HandlerOutB());
//        pipeline.addLast(new HandlerOutC());
        //先解码
        pipeline.addLast(new PacketDecoder())
                .addLast(new MyLoginSimpleChannelHandler())
                .addLast(new AuthHandler())
                .addLast(new JoinGroupHandler())
                .addLast(new ListGroupReqHandler())
                .addLast(new QuitGroupReqHandler())
                .addLast(new PointToPointMessageHandler())
                .addLast(new MyRequestSimpleChannelHandler())
                .addLast(new LogoutReqHandler())
                .addLast(new GroupMessageReqHandler())
                .addLast(new MyCreateGroupChannelHandler())
                //编码
                .addLast(new PacketEncoding());
    }
}
