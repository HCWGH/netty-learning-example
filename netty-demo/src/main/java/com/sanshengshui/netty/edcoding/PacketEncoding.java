package com.sanshengshui.netty.edcoding;

import com.sanshengshui.netty.protocol.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author HCW
 * @date 2023/2/15 19:38
 * @todo Netty官方提供编码Handler
 */
public class PacketEncoding extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Packet packet, ByteBuf byteBuf) throws Exception {
        PacketCodec.encode(packet, byteBuf);
    }
}
