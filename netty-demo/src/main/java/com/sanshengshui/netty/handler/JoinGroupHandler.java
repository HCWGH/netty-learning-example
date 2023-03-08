package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.message.req.JoinGroupReq;
import com.sanshengshui.netty.message.req.MessageReq;
import com.sanshengshui.netty.message.res.JoinGroupRes;
import com.sanshengshui.netty.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @author HCW
 * @date 2023/3/8 15:00
 * @todo
 */
public class JoinGroupHandler extends SimpleChannelInboundHandler<JoinGroupReq> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupReq msg) throws Exception {
        String groupId = msg.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        JoinGroupRes joinGroupRes = new JoinGroupRes();
        Channel channel = ctx.channel();
        if (channelGroup != null) {
            //TODO 已在群里的每个成员发送一条消息
            channelGroup.add(channel);
            joinGroupRes.setRes(true);
            joinGroupRes.setMsg("加入群聊成功");
        } else {
            joinGroupRes.setRes(false);
            joinGroupRes.setMsg("加入群聊失败，群聊id:{0}不存在".replace("{0}", groupId));
        }
        channel.writeAndFlush(joinGroupRes);
    }
}
