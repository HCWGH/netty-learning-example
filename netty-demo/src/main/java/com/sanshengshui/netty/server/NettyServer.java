package com.sanshengshui.netty.server;

import com.sanshengshui.netty.server.initChannel.ServerInitChannel;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.concurrent.TimeUnit;

/**
 * @author HCW
 * @date 2023/2/6 17:36
 * @todo
 */
public class NettyServer {
    public static Integer RETRY_COUNT = 5;

    public static void main(String[] args) {
        NioEventLoopGroup boss = new NioEventLoopGroup(5);
        NioEventLoopGroup worker = new NioEventLoopGroup(5);
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ServerInitChannel())
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true);
        bind(9091, bootstrap, RETRY_COUNT);
    }

    /**
     * 绑定端口
     *
     * @param port
     * @param bootstrap
     * @param retry
     */
    public static void bind(int port, ServerBootstrap bootstrap, int retry) {
        bootstrap.bind(port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("绑定端口 " + port + " 成功");
            } else {
                System.out.println("绑定端口 " + port + " 失败,尝试再次进行绑定");
                if (retry == 0) {
                    return;
                }
                //重试时间指数增长
                long delay = 1L << (RETRY_COUNT - retry);
                int remainReTry = retry - 1;
                bootstrap.config().group().schedule(() -> bind(port + 1, bootstrap, remainReTry), delay, TimeUnit.SECONDS);
            }
        });
    }
}
