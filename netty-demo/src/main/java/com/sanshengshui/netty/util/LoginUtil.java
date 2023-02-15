package com.sanshengshui.netty.util;

import com.sanshengshui.netty.model.AttriButes;
import io.netty.channel.Channel;

/**
 * @author HCW
 * @date 2023/2/13 16:40
 * @todo
 */
public class LoginUtil {

    /**
     * 设置为已登录
     *
     * @param channel
     */
    public static void markLogin(Channel channel) {
        channel.attr(AttriButes.LOG_FLAG).set(true);
    }

    /**
     * 判断当前用户是否已登录
     *
     * @param channel
     * @return
     */
    public static Boolean hasLogin(Channel channel) {
        Boolean hasLogin = channel.attr(AttriButes.LOG_FLAG).get();
        return hasLogin != null && hasLogin;
    }

}
