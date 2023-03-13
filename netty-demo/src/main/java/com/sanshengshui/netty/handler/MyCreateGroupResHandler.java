package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.message.res.CreateGroupRes;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author HCW
 * @date 2023/3/3 17:34
 * @todo
 */
@ChannelHandler.Sharable
public class MyCreateGroupResHandler extends SimpleChannelInboundHandler<CreateGroupRes> {
    public static final MyCreateGroupResHandler INSTANCE = new MyCreateGroupResHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupRes msg) throws Exception {
        Boolean succeed = msg.getSucceed();
        if (succeed) {
            List<String> userNameList = msg.getUserNameList();
            StringJoiner joiner = new StringJoiner(",");
            userNameList.forEach(joiner::add);
            System.out.println("群聊创建成功,群信息如下:\n" + "群ID:" + msg.getGroupId() + "\n群成员:" + joiner);
        }

    }
}
