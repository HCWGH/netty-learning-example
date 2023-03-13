package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.message.req.QuitGroupReq;
import com.sanshengshui.netty.message.res.QuitGroupRes;
import com.sanshengshui.netty.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @author HCW
 * @date 2023/3/8 16:01
 * @todo
 */
@ChannelHandler.Sharable
public class QuitGroupReqHandler extends SimpleChannelInboundHandler<QuitGroupReq> {
    public static final QuitGroupReqHandler INSTANCE = new QuitGroupReqHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupReq msg) throws Exception {
        String groupId = msg.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        QuitGroupRes quitGroupRes = new QuitGroupRes();
        Channel channel = ctx.channel();
        if (channelGroup != null) {
            channelGroup.remove(channel);
            quitGroupRes.setRes(true);
            quitGroupRes.setMsg("您已成功退出群聊：" + groupId);
            //TODO 通知群里其他人
        } else {
            quitGroupRes.setRes(false);
            quitGroupRes.setMsg("退出群聊失败,群id:{0}信息不存在".replace("{0}", groupId));
        }
        channel.writeAndFlush(quitGroupRes);
    }
}
