package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.message.req.GroupMessageReq;
import com.sanshengshui.netty.message.res.GroupMessageRes;
import com.sanshengshui.netty.model.UserSession;
import com.sanshengshui.netty.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @author HCW
 * @date 2023/3/8 19:48
 * @todo
 */
@ChannelHandler.Sharable
public class GroupMessageReqHandler extends SimpleChannelInboundHandler<GroupMessageReq> {
    public static final GroupMessageReqHandler INSTANCE = new GroupMessageReqHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageReq msg) throws Exception {
        String groupId = msg.getGroupId();
        String groupMessage = msg.getGroupMessage();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        Channel channel = ctx.channel();
        UserSession sendUserSession = SessionUtil.getUserSession(channel);
        GroupMessageRes messageRes = new GroupMessageRes();
        if (channelGroup != null) {
            String sender = sendUserSession.getUserName() + "|" + sendUserSession.getUserId();
            messageRes.setSendUser(sender);
            messageRes.setGroupId(groupId);
            messageRes.setMessage(sender + " >>>SAY: " + groupMessage);
            messageRes.setRes(true);
            channelGroup.writeAndFlush(messageRes);
        } else {
            messageRes.setRes(false);
            messageRes.setMessage("发送群消息失败，群组{0}不存在".replace("{0}", groupId));
            channel.writeAndFlush(messageRes);
        }
    }
}
