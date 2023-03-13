package com.sanshengshui.netty.edcoding;

import com.sanshengshui.netty.protocol.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.List;

/**
 * @author HCW
 * @date 2023/3/13 20:05
 * @todo 编解码共同实现类，底层同时实现 InBound和OutBound
 */
@ChannelHandler.Sharable
public class MixCodecHandler extends MessageToMessageCodec<ByteBuf, Packet> {
    public static final MixCodecHandler INSTANCE = new MixCodecHandler();

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet msg, List<Object> out) throws Exception {
        out.add(PacketCodec.encode(msg));
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        out.add(PacketCodec.decode(msg));
    }
}
