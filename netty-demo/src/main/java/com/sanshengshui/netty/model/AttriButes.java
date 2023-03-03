package com.sanshengshui.netty.model;

import io.netty.util.AttributeKey;

/**
 * @author HCW
 * @date 2023/2/13 16:49
 * @todo
 */
public class AttriButes {
    public static final AttributeKey<Boolean> LOG_FLAG=AttributeKey.newInstance("LOGIN_FLAG");
    public static final AttributeKey<UserSession> USER_SESSION=AttributeKey.newInstance("USER_SESSION");
}
