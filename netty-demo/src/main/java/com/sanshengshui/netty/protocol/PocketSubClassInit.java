package com.sanshengshui.netty.protocol;

import com.sanshengshui.netty.model.CommandType;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HCW
 * @date 2023/2/7 17:25
 * @todo
 */
public class PocketSubClassInit {
    public static final Map<Byte, Class<? extends Packet>> PACKET_COMMAND_MAP = new HashMap<>(16);

    static {
        init();
    }

    public static Class<? extends Packet> getPacketClass(Byte type) {
        return PACKET_COMMAND_MAP.get(type);
    }

    @SuppressWarnings("unchecked")
    public static void init() {
        for (CommandType data : CommandType.values()) {
            Class<?> instance = data.getClassInstance();
            if (Packet.class.isAssignableFrom(instance)) {
                PACKET_COMMAND_MAP.put(data.getBytes(), (Class<? extends Packet>) instance);
            }
        }
    }
}
