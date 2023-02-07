package com.sanshengshui.netty.protocol.serialize.serializeEum;

import com.sanshengshui.netty.protocol.serialize.BodySerialize;
import com.sanshengshui.netty.protocol.serialize.serializeImpl.JsonSerialization;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HCW
 * @date 2023/2/7 14:26
 * @todo
 */
public enum SerializeEum {
    JSON_SERIALIZE((byte) 1, new JsonSerialization());

    private Byte serializeAlgorithm;
    private BodySerialize bodySerialize;
    public static final Map<Byte, SerializeEum> SERIALIZE_EUM_MAP = new HashMap<>(16);

    static {
        for (SerializeEum serializeEum : SerializeEum.values()) {
            SERIALIZE_EUM_MAP.put(serializeEum.getSerializeAlgorithm(), serializeEum);
        }
    }

    SerializeEum(Byte serializeAlgorithm, BodySerialize bodySerialize) {
        this.serializeAlgorithm = serializeAlgorithm;
        this.bodySerialize = bodySerialize;
    }

    public Byte getSerializeAlgorithm() {
        return serializeAlgorithm;
    }

    public void setSerializeAlgorithm(Byte serializeAlgorithm) {
        this.serializeAlgorithm = serializeAlgorithm;
    }

    public BodySerialize getBodySerialize() {
        return bodySerialize;
    }

    public void setBodySerialize(BodySerialize bodySerialize) {
        this.bodySerialize = bodySerialize;
    }

    public static BodySerialize getSerializeAlgorithm(Byte id) {
        SerializeEum serializeEum = SERIALIZE_EUM_MAP.get(id);
        if (serializeEum != null) {
            return serializeEum.bodySerialize;
        }
        return JSON_SERIALIZE.bodySerialize;
    }
}
