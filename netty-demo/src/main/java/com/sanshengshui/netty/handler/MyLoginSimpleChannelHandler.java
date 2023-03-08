package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.message.req.LoginReq;
import com.sanshengshui.netty.message.res.LoinRes;
import com.sanshengshui.netty.model.UserSession;
import com.sanshengshui.netty.util.LoginUtil;
import com.sanshengshui.netty.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author HCW
 * @date 2023/2/15 19:15
 * @todo 根据泛型处理登录请求
 */
public class MyLoginSimpleChannelHandler extends SimpleChannelInboundHandler<LoginReq> {
    private static final Map<String, String> USER_PASSWORD_MAP = new HashMap<>(16);

    static {
        USER_PASSWORD_MAP.put("cxk", "ZhiYinNiTaiMei");
        USER_PASSWORD_MAP.put("mbg", "JieHuaFa");
        USER_PASSWORD_MAP.put("hcw", "1E7753");
        USER_PASSWORD_MAP.put("hxk", "12C7613");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoginReq loginReq) throws Exception {
        String userName = loginReq.getUserName();
        String password = loginReq.getPassword();
        LoinRes loinRes = new LoinRes();
        String response = "Account password error";
        boolean login = false;
        String userId = "";
        if (valid(userName, password)) {
            response = "Hello ," + userName + " welcome to our service";
            login = true;
            UserSession userSession = new UserSession();
            userId = UUID.randomUUID().toString().split("-")[0];
            loinRes.setUserId(userId);
            userSession.setUserId(userId);
            userSession.setUserName(userName);
            loinRes.setUserName(userName);
            LoginUtil.markLogin(channelHandlerContext.channel());
            SessionUtil.bindSession(userSession, channelHandlerContext.channel());
        }
        loinRes.setSuccessful(login);
        loinRes.setResponseMes(response);
        System.out.println("================User login information " + userName + "|" + password + "|" + userId + "=================");
        //ByteBuf encode = PacketCodec.encode(loinRes);
        channelHandlerContext.channel().writeAndFlush(loinRes);
    }

    public boolean valid(String userName, String password) {
        if (!USER_PASSWORD_MAP.containsKey(userName) || !USER_PASSWORD_MAP.get(userName).equals(password)) {
            return false;
        }
        return true;
    }
}
