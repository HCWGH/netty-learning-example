package com.sanshengshui.netty.util;

import com.sanshengshui.netty.model.AttriButes;
import com.sanshengshui.netty.model.UserSession;
import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author HCW
 * @date 2023/3/3 16:09
 * @todo
 */
public class SessionUtil {
    private static final Map<String, Channel> USER_CHANNEL_MAP = new ConcurrentHashMap<>(16);

    public static void bindSession(UserSession userSession, Channel channel) {
        USER_CHANNEL_MAP.put(userSession.getUserId(), channel);
        channel.attr(AttriButes.USER_SESSION).set(userSession);
    }

    public static void unBindSession(Channel channel) {
        UserSession userSession = channel.attr(AttriButes.USER_SESSION).get();
        if (userSession != null) {
            USER_CHANNEL_MAP.remove(userSession.getUserId());
            channel.attr(AttriButes.USER_SESSION).set(null);
        }
    }

    public static UserSession getUserSession(Channel channel) {
        return channel.attr(AttriButes.USER_SESSION).get();
    }

    public static Channel getChannel(String userId) {
        return USER_CHANNEL_MAP.get(userId);
    }


}
