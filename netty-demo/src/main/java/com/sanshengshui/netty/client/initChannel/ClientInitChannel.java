package com.sanshengshui.netty.client.initChannel;

import com.sanshengshui.netty.client.handler.ClientBaseHandler;
import com.sanshengshui.netty.edcoding.PacketDecoder;
import com.sanshengshui.netty.edcoding.PacketEncoding;
import com.sanshengshui.netty.handler.*;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author HCW
 * @date 2023/2/6 19:38
 * @todo
 */
public class ClientInitChannel extends ChannelInitializer<NioSocketChannel> {
    private final static ClientBaseHandler BASE_CLIENT_HANDLER = new ClientBaseHandler();

    @Override
    protected void initChannel(NioSocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        //pipeline.addLast(BASE_CLIENT_HANDLER);
        pipeline.addLast(new PacketDecoder())
                .addLast(new LoginResponseSimChannelHandler())
                .addLast(new MyCreateGroupResHandler())
                .addLast(new JoinGroupResHandler())
                .addLast(new ListGroupResHandler())
                .addLast(new QuitGroupResHandler())
                .addLast(new LogoutResHandler())
                .addLast(new PointToPointResHandler())
                .addLast(new GroupMessageResHandler())
                .addLast(new MessageResponseSimpleChannelHandler())
                .addLast(new PacketEncoding());
    }
}
