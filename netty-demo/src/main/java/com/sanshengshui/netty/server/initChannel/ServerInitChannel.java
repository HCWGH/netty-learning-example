package com.sanshengshui.netty.server.initChannel;

import com.sanshengshui.netty.server.handler.ServerBaseHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
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
        nioSocketChannel.pipeline().addLast(SERVER_BASE_HANDLER);
    }
}
