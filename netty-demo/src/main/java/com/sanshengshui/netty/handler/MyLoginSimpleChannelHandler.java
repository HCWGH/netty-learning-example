package com.sanshengshui.netty.handler;

import com.sanshengshui.netty.message.req.LoginReq;
import com.sanshengshui.netty.message.res.LoinRes;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.HashMap;
import java.util.Map;

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
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoginReq loginReq) throws Exception {
        String userName = loginReq.getUserName();
        String password = loginReq.getPassword();
        System.out.println("================User login information " + userName + "|" + password + "=================");
        if (USER_PASSWORD_MAP.containsKey(userName)) {
            if (USER_PASSWORD_MAP.get(userName).equals(password)) {

            }
        }
        LoinRes loinRes = new LoinRes();
        String response = "Hello ," + userName + " welcome to our service";
        loinRes.setSuccessful(true);
        loinRes.setResponseMes(response);
        //ByteBuf encode = PacketCodec.encode(loinRes);
        channelHandlerContext.channel().writeAndFlush(loinRes);
    }
}
