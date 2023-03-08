package com.sanshengshui.netty.model;

import com.sanshengshui.netty.message.req.*;
import com.sanshengshui.netty.message.res.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HCW
 * @date 2023/2/6 20:24
 * @todo 指令类型
 */
public enum CommandType {
    LOGIN_REQUEST((byte) 1, "LOGIN_REQUEST", LoginReq.class),
    LOGIN_RESPONSE((byte) 2, "LOGIN_RESPONSE", LoinRes.class),
    MESSAGE_REQUEST((byte) 3, "MESSAGE_REQUEST", MessageReq.class),
    MESSAGE_RESPONSE((byte) 4, "MESSAGE_RESPONSE", MessageRes.class),
    CREATE_GROUP_REQUEST((byte) 5, "CREATE_GROUP_REQUEST", CreateGroupReq.class),
    CREATE_GROUP_RESPONSE((byte) 6, "CREATE_GROUP_RESPONSE", CreateGroupRes.class),
    LOGOUT_REQUEST((byte) 7, "LOGOUT_REQUEST", LogoutReq.class),
    LOGOUT_RESPONSE((byte) 8, "LOGOUT_RESPONSE", LogoutRes.class),
    JOIN_GROUP_REQUEST((byte) 9, "JOIN_GROUP_REQUEST", JoinGroupReq.class),
    JOIN_GROUP_RESPONSE((byte) 10, "JOIN_GROUP_RESPONSE", JoinGroupRes.class),
    LIST_GROUP_REQUEST((byte) 11, "LIST_GROUP_REQUEST", ListGroupReq.class),
    LIST_GROUP_RESPONSE((byte) 12, "LIST_GROUP_RESPONSE", ListGroupRes.class),
    QUIT_GROUP_REQUEST((byte) 13, "QUIT_GROUP_REQUEST", QuitGroupReq.class),
    QUIT_GROUP_RESPONSE((byte) 14, "QUIT_GROUP_RESPONSE", QuitGroupRes.class),
    GROUP_MESSAGE_REQUEST((byte) 15, "GROUP_MESSAGE_REQUEST", GroupMessageReq.class),
    GROUP_MESSAGE_RESPONSE((byte) 16, "GROUP_MESSAGE_RESPONSE", GroupMessageRes.class),
    ;
    private Byte bytes;
    private String name;
    private Class<?> classInstance;

    CommandType(Byte bytes, String name, Class<?> classInstance) {
        this.bytes = bytes;
        this.name = name;
        this.classInstance = classInstance;
    }


    public static final Map<Byte, CommandType> COMMAND_MAP = new HashMap<>(16);

    static {
        for (CommandType data : CommandType.values()) {
            COMMAND_MAP.put(data.bytes, data);
        }
    }

    public Byte getBytes() {
        return bytes;
    }

    public void setBytes(Byte bytes) {
        this.bytes = bytes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getClassInstance() {
        return classInstance;
    }

    public void setClassInstance(Class<?> classInstance) {
        this.classInstance = classInstance;
    }

    public static CommandType getCommandByType(Byte type) {
        return COMMAND_MAP.get(type);
    }
}
