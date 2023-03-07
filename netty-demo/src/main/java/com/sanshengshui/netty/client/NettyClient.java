package com.sanshengshui.netty.client;

import com.sanshengshui.netty.client.initChannel.ClientInitChannel;
import com.sanshengshui.netty.command.impl.CommandHandleEnter;
import com.sanshengshui.netty.command.impl.LoginCommandHandle;
import com.sanshengshui.netty.edcoding.PacketCodec;
import com.sanshengshui.netty.message.req.MessageReq;
import com.sanshengshui.netty.util.LoginUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author HCW
 * @date 2023/2/6 19:23
 * @todo
 */
public class NettyClient {
    public static Integer MAX_RETRY = 5;

    public static void main(String[] args) {
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .handler(new ClientInitChannel());
        bind(9091, "127.0.0.1", bootstrap, MAX_RETRY);
    }

    public static void bind(int port, String ip, Bootstrap bootstrap, int retry) {
        bootstrap.connect(ip, port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("客户端绑定服务成功，ip=" + ip + "，端口=" + port);
                Channel channel = ((ChannelFuture) future).channel();
                //clientSendMessageThread(channel).start();
                consoleSendMessage(channel);
            } else {
                if (retry == 0) {
                    System.out.println("客户端绑定服务失败，ip=" + ip + "，端口=" + port + ",重试次数已使用完毕");
                    return;
                }
                long delay = 1L << (MAX_RETRY - retry);
                int retryCount = retry - 1;
                bootstrap.config().group().schedule(() -> bind(port, ip, bootstrap, retryCount), delay, TimeUnit.SECONDS);
            }
        });
    }

    public static Thread clientSendMessageThread(Channel channel) {
        return new Thread(() -> {
            while (!Thread.interrupted()) {
                if (LoginUtil.hasLogin(channel)) {
                    System.out.println("send message to server:");
                    Scanner scanner = new Scanner(System.in);
                    String nextLine = scanner.nextLine();
                    MessageReq messageReq = new MessageReq();
                    messageReq.setMessage(nextLine);
                    ByteBuf byteBuf = PacketCodec.encode(messageReq);
                    channel.writeAndFlush(byteBuf);
                }
            }
        });
    }

    public static void consoleSendMessage(Channel channel) {
        LoginCommandHandle loginCommandHandle = new LoginCommandHandle();
        CommandHandleEnter handleEnter = new CommandHandleEnter();
        new Thread(() -> {
            while (!Thread.interrupted()) {
                Scanner scanner = new Scanner(System.in);
                if (!LoginUtil.hasLogin(channel)) {
                    loginCommandHandle.execute(scanner, channel);
                } else {
                    handleEnter.execute(scanner, channel);
                }
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
