package com.sanshengshui.netty.protocol.serialize;

import com.sanshengshui.netty.protocol.serialize.serializeEum.SerializeEum;

/**
 * @author HCW
 * @date 2023/2/7 14:19
 * @todo
 */
public interface BodySerialize {

    /**
     *
     * @param data
     * @return 序列化
     */
    byte[] serialize(Object data);

    /**
     *
     * @param dataBytes
     * @param classType
     * @param <T>
     * @return 反序列化
     */
    <T> T deserialization(byte[] dataBytes, Class<T> classType);
}
