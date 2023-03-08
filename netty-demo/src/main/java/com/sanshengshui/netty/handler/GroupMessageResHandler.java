package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.message.res.GroupMessageRes;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author HCW
 * @date 2023/3/8 19:57
 * @todo
 */
public class GroupMessageResHandler extends SimpleChannelInboundHandler<GroupMessageRes> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageRes msg) throws Exception {
        String message = msg.getMessage();
        String groupId = msg.getGroupId();
        Boolean res = msg.getRes();
        if (res) {
            System.out.println("Receive A message from group：" + groupId + "\n" + message);
        } else {
            System.out.println(message);
        }
    }
}
