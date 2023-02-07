package com.sanshengshui.netty.protocol;


import com.sanshengshui.netty.protocol.serialize.serializeEum.SerializeEum;

/**
 * @author HCW
 * @date 2023/2/7 13:54
 * @todo 协议抽象类
 */
public abstract class Packet {
    private Byte version = 1;
    private Byte serializeAlgorithm = SerializeEum.JSON_SERIALIZE.getSerializeAlgorithm();
    /**
     * 获取指令类型
     *
     * @return
     */
    public abstract Byte getCommandType();

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }

    public Byte getSerializeAlgorithm() {
        return serializeAlgorithm;
    }

    public void setSerializeAlgorithm(Byte serializeAlgorithm) {
        this.serializeAlgorithm = serializeAlgorithm;
    }

}
