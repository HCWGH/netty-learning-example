package com.sanshengshui.netty.protocol.serialize.serializeImpl;

import com.alibaba.fastjson.JSON;
import com.sanshengshui.netty.protocol.serialize.BodySerialize;

/**
 * @author HCW
 * @date 2023/2/7 14:29
 * @todo json序列化
 */
public class JsonSerialization implements BodySerialize {
    @Override
    public byte[] serialize(Object data) {
        return JSON.toJSONBytes(data);
    }

    @Override
    public <T> T deserialization(byte[] dataBytes, Class<T> classType) {
        return JSON.parseObject(dataBytes, classType);
    }
}
