package com.sanshengshui.netty.edcoding;

import com.sanshengshui.netty.protocol.Packet;
import com.sanshengshui.netty.protocol.PocketSubClassInit;
import com.sanshengshui.netty.protocol.serialize.BodySerialize;
import com.sanshengshui.netty.protocol.serialize.serializeEum.SerializeEum;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * @author HCW
 * @date 2023/2/7 15:08
 * @todo Packet协议消息体：魔数(4字节)+版本号(1字节)+序列化算法(1字节)+指令类型(1字节)+数据长度（4字节）+数据(不限制)
 */
public class PacketCodec {
    /**
     * 魔数
     */
    public static final int MAGIC_NUMBER = 0X9527;

    /**
     * 数据编码用户交互传输
     *
     * @param packet
     * @return
     */
    public ByteBuf encode(Packet packet) {
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer();
        //写入魔数
        byteBuf.writeInt(MAGIC_NUMBER);
        //写入版本号
        byteBuf.writeByte(packet.getVersion());
        //写入枚举类对应的序列化算法
        byteBuf.writeByte(packet.getSerializeAlgorithm());
        //指令类型
        byteBuf.writeByte(packet.getCommandType());
        //数据长度
        Byte serializeAlgorithm = packet.getSerializeAlgorithm();
        BodySerialize serialize = SerializeEum.getSerializeAlgorithm(serializeAlgorithm);
        //序列化
        byte[] bodyData = serialize.serialize(packet);
        int byteLength = bodyData.length;
        byteBuf.writeInt(byteLength);
        //数据
        byteBuf.writeBytes(bodyData);
        return byteBuf;
    }

    /**
     * 数据解码获取具体数据
     *
     * @param byteBuf
     * @return
     */
    public Packet decode(ByteBuf byteBuf) {
        //跳过魔数验证(4字节)
        byteBuf.skipBytes(4);
        //跳过版本号(1字节)
        byteBuf.skipBytes(1);
        //获取序列化算法(1字节)
        byte serializeAlgorithm = byteBuf.readByte();
        //指令类型(1字节)
        byte commandType = byteBuf.readByte();
        //数据长度(4字节)
        int dataLen = byteBuf.readInt();
        //数据
        byte[] dataBytes = new byte[dataLen];
        byteBuf.readBytes(dataBytes);
        //反序列化
        BodySerialize serialize = SerializeEum.getSerializeAlgorithm(serializeAlgorithm);
        Class<? extends Packet> instance = PocketSubClassInit.getPacketClass(commandType);
        return serialize.deserialization(dataBytes, instance);
    }
}
