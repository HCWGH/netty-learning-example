package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.message.req.LogoutReq;
import com.sanshengshui.netty.message.res.LogoutRes;
import com.sanshengshui.netty.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author HCW
 * @date 2023/3/6 17:56
 * @todo
 */
public class LogoutReqHandler extends SimpleChannelInboundHandler<LogoutReq> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutReq msg) throws Exception {
        SessionUtil.unBindSession(ctx.channel());
        LogoutRes logoutRes = new LogoutRes();
        logoutRes.setRes(true);
        logoutRes.setMsg("Logout success");
        ctx.channel().writeAndFlush(logoutRes);
    }
}
