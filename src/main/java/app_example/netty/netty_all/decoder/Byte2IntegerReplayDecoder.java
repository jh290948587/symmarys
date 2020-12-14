package app_example.netty.netty_all.decoder;

/**
 * create by 尼恩 @ 疯狂创客圈
 **/


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class Byte2IntegerReplayDecoder extends ReplayingDecoder {
    @Override
    public void decode(ChannelHandlerContext ctx, ByteBuf in,
                       List<Object> out) {
        int i = in.readInt();
        System.out.println("解码出一个整数: " + i);
        out.add(i);
    }
}