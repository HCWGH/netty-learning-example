package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.message.req.ListGroupReq;
import com.sanshengshui.netty.message.res.ListGroupRes;
import com.sanshengshui.netty.model.UserSession;
import com.sanshengshui.netty.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

import java.util.StringJoiner;

/**
 * @author HCW
 * @date 2023/3/8 15:22
 * @todo
 */
@ChannelHandler.Sharable
public class ListGroupReqHandler extends SimpleChannelInboundHandler<ListGroupReq> {
    public final static ListGroupReqHandler INSTANCE = new ListGroupReqHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupReq msg) throws Exception {
        String groupId = msg.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        ListGroupRes listGroupRes = new ListGroupRes();
        StringJoiner joiner = new StringJoiner(",");
        if (channelGroup != null) {
            channelGroup.forEach(channel -> {
                UserSession userSession = SessionUtil.getUserSession(channel);
                joiner.add("[" + userSession.getUserName() + "|" + userSession.getUserId() + "]");
            });
            listGroupRes.setRes(true);
            listGroupRes.setMsg("群成员列表：" + joiner);
        } else {
            listGroupRes.setRes(false);
            listGroupRes.setMsg("查询的群里不存在，群聊id:" + groupId);
        }
        ctx.channel().writeAndFlush(listGroupRes);
    }
}
