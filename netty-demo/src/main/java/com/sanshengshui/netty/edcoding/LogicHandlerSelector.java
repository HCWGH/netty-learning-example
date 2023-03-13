package com.sanshengshui.netty.edcoding;

import com.sanshengshui.netty.protocol.Packet;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HCW
 * @date 2023/3/13 20:31
 * @todo
 */
@ChannelHandler.Sharable
public class LogicHandlerSelector extends SimpleChannelInboundHandler<Packet> {
    public static final LogicHandlerSelector INSTANCE = new LogicHandlerSelector();
    private static final Map<Byte, SimpleChannelInboundHandler<? extends Packet>> HANDLER_SELECTOR_MAP = new HashMap<>(16);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Packet msg) throws Exception {

    }

    @PostConstruct
    public void init() {
       //HANDLER_SELECTOR_MAP.put()
    }
}
