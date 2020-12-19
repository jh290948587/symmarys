package app_example.netty.netty_all.echoServer.handler.in;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

@ChannelHandler.Sharable
public class InHandlerA extends ChannelInboundHandlerAdapter {
    public static final InHandlerA INSTANCE = new InHandlerA();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        System.out.println("msg type: " + (in.hasArray()?"堆内存":"直接内存"));

        int len = in.readableBytes();
        byte[] arr = new byte[len];
        in.getBytes(0, arr);
        System.out.println("server received: " + new String(arr, "UTF-8"));

        //写回数据，异步任务
        System.out.println("写回前，msg.refCnt:" + ((ByteBuf) msg).refCnt());
//        将数据直接原封不动的写回客户端，因为上面调用的是getBytes，可以直接使用msg写回。
//        如果调用的是readBytes，则不可直接使用msg写回
//        ChannelFuture f = ctx.writeAndFlush(msg);
        super.channelRead(ctx, msg);
//        f.addListener((ChannelFuture futureListener) -> {
//            System.out.println("写回后，msg.refCnt:" + ((ByteBuf) msg).refCnt());
//        });
    }
}
