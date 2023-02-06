package com.sanshengshui.netty.model;

/**
 * @author HCW
 * @date 2023/2/6 20:24
 * @todo 指令类型
 */
public enum CommandType {
    LOGIN_IN("LOGIN"),

    ;

    private Byte bytes;
    private String name;

    CommandType(Byte bytes, String name) {
        this.bytes = bytes;
        this.name = name;
    }

    CommandType(String name) {
        this.bytes = 1;
        this.name = name;
    }

    CommandType() {
        this.bytes = 1;
        this.name = "UNDEFINE NAME";
    }
}
