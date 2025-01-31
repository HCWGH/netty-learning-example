package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.message.req.CreateGroupReq;
import com.sanshengshui.netty.message.res.CreateGroupRes;
import com.sanshengshui.netty.model.UserSession;
import com.sanshengshui.netty.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.DefaultChannelGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HCW
 * @date 2023/3/3 16:06
 * @todo
 */
@ChannelHandler.Sharable
public class MyCreateGroupChannelHandler extends SimpleChannelInboundHandler<CreateGroupReq> {
    public static final MyCreateGroupChannelHandler INSTANCE = new MyCreateGroupChannelHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupReq msg) throws Exception {
        List<String> userIdList = msg.getUserIdList();
        List<String> userNameList = new ArrayList<>();
        DefaultChannelGroup channelGroup = new DefaultChannelGroup(ctx.executor());
        //每个用户的Channel加入channelGroup
        userIdList.forEach(userId -> {
            Channel channel = SessionUtil.getChannel(userId);
            if (channel != null) {
                channelGroup.add(channel);
                UserSession session = SessionUtil.getUserSession(channel);
                userNameList.add("[" + session.getUserName() + "|" + session.getUserId() + "]");
            }
        });
        String groupId = "groupId_" + System.currentTimeMillis() + "_" + (int) (Math.random() * 1000);
        CreateGroupRes groupRes = new CreateGroupRes();
        groupRes.setGroupId(groupId);
        groupRes.setUserNameList(userNameList);
        groupRes.setSucceed(true);
        SessionUtil.bindGroupSession(groupId, channelGroup);
        //response
        userIdList.forEach(userId -> {
            Channel channel = SessionUtil.getChannel(userId);
            if (channel != null) {
                channel.writeAndFlush(groupRes);
            }
        });
    }
}
