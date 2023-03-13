package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.message.req.MessageReq;
import com.sanshengshui.netty.message.res.MessageRes;
import com.sanshengshui.netty.model.AttriButes;
import com.sanshengshui.netty.model.UserSession;
import com.sanshengshui.netty.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author HCW
 * @date 2023/3/6 19:34
 * @todo
 */
@ChannelHandler.Sharable
public class PointToPointMessageHandler extends SimpleChannelInboundHandler<MessageReq> {
    public static final PointToPointMessageHandler INSTANCE = new PointToPointMessageHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageReq msg) throws Exception {
        String message = msg.getMessage();
        String receiver = msg.getReceiver();
        if (receiver == null) {
            ctx.writeAndFlush("The user does not exist");
            return;
        }
        //服务器进行消息转发
        Channel channel = SessionUtil.getChannel(receiver);
        UserSession curUserSession = ctx.channel().attr(AttriButes.USER_SESSION).get();
        MessageRes messageRes = new MessageRes();
        messageRes.setMessage(message);
        messageRes.setSendUser(curUserSession.getUserId());
        messageRes.setSendUserName(curUserSession.getUserName());
        channel.writeAndFlush(messageRes);
    }
}
