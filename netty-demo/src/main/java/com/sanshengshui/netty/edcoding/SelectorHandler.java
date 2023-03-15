package com.sanshengshui.netty.edcoding;

import com.sanshengshui.netty.handler.*;
import com.sanshengshui.netty.model.CommandType;
import com.sanshengshui.netty.protocol.Packet;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HCW
 * @date 2023/3/15 17:48
 * @todo 透传, Handler选择器, 缩减传播路径
 */
@ChannelHandler.Sharable
public class SelectorHandler extends SimpleChannelInboundHandler<Packet> {
    public static final SelectorHandler INSTANCE = new SelectorHandler();
    public static final Map<Byte, SimpleChannelInboundHandler<? extends Packet>> HANDLER_MAP = new HashMap<>();

    static {
        HANDLER_MAP.put(CommandType.CREATE_GROUP_REQUEST.getBytes(), MyCreateGroupChannelHandler.INSTANCE);
        HANDLER_MAP.put(CommandType.CREATE_GROUP_RESPONSE.getBytes(), MyCreateGroupResHandler.INSTANCE);
        HANDLER_MAP.put(CommandType.JOIN_GROUP_REQUEST.getBytes(), JoinGroupHandler.INSTANCE);
        HANDLER_MAP.put(CommandType.JOIN_GROUP_RESPONSE.getBytes(), JoinGroupResHandler.INSTANCE);
        HANDLER_MAP.put(CommandType.LIST_GROUP_REQUEST.getBytes(), ListGroupReqHandler.INSTANCE);
        HANDLER_MAP.put(CommandType.LIST_GROUP_RESPONSE.getBytes(), ListGroupResHandler.INSTANCE);
        HANDLER_MAP.put(CommandType.LOGIN_RESPONSE.getBytes(), LoginResponseSimChannelHandler.INSTANCE);
        HANDLER_MAP.put(CommandType.LOGOUT_REQUEST.getBytes(), LogoutReqHandler.INSTANCE);
        HANDLER_MAP.put(CommandType.LOGOUT_RESPONSE.getBytes(), LogoutResHandler.INSTANCE);
        HANDLER_MAP.put(CommandType.MESSAGE_RESPONSE.getBytes(), MessageResponseSimpleChannelHandler.INSTANCE);
        HANDLER_MAP.put(CommandType.GROUP_MESSAGE_REQUEST.getBytes(), GroupMessageReqHandler.INSTANCE);
        HANDLER_MAP.put(CommandType.GROUP_MESSAGE_RESPONSE.getBytes(), GroupMessageResHandler.INSTANCE);
        HANDLER_MAP.put(CommandType.MESSAGE_REQUEST.getBytes(), MyRequestSimpleChannelHandler.INSTANCE);
        HANDLER_MAP.put(CommandType.QUIT_GROUP_REQUEST.getBytes(), QuitGroupReqHandler.INSTANCE);
        HANDLER_MAP.put(CommandType.QUIT_GROUP_RESPONSE.getBytes(), QuitGroupResHandler.INSTANCE);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Packet msg) throws Exception {
        HANDLER_MAP.get(msg.getCommandType()).channelRead(ctx, msg);
    }
}
