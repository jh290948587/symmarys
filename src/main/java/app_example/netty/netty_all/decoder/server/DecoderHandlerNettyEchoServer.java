package app_example.netty.netty_all.decoder.server;


import app_example.netty.netty_all.decoder.*;
import app_example.netty.netty_all.echoServer.handler.in.InHandlerA;
import app_example.netty.netty_all.echoServer.handler.in.InHandlerB;
import app_example.netty.netty_all.echoServer.handler.in.InHandlerC;
import app_example.netty.netty_all.echoServer.handler.out.OutHandlerA;
import app_example.netty.netty_all.echoServer.handler.out.OutHandlerB;
import app_example.netty.netty_all.echoServer.handler.out.OutHandlerC;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class DecoderHandlerNettyEchoServer {

    private final int serverPort;
    ServerBootstrap b = new ServerBootstrap();

    public DecoderHandlerNettyEchoServer(int port) {
        this.serverPort = port;
    }

    public void runServer() {
        //创建reactor 线程组
        EventLoopGroup bossLoopGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerLoopGroup = new NioEventLoopGroup();

        try {
            //1 设置reactor 线程组
            b.group(bossLoopGroup, workerLoopGroup);
            //2 设置nio类型的channel
            b.channel(NioServerSocketChannel.class);
            //3 设置监听端口
            b.localAddress(serverPort);
            //4 设置通道的参数
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
            b.childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);

            //5 装配子通道流水线
            b.childHandler(new ChannelInitializer<SocketChannel>() {
                //有连接到达时会创建一个channel
                protected void initChannel(SocketChannel ch) throws Exception {
//                    整数解码器
                    ch.pipeline().addLast(new Byte2IntegerDecoder());
                    ch.pipeline().addLast(new IntegerProcessHandler());

//                    整数相加解码器
//                    ch.pipeline().addLast(new IntegerAddDecoder());

//                    字符串分包解码器
//                    ch.pipeline().addLast(new StringReplayDecoder());
//                    ch.pipeline().addLast(new StringProcessHandler());

                }
            });
            // 6 开始绑定server
            // 通过调用sync同步方法阻塞直到绑定成功
            ChannelFuture channelFuture = b.bind().sync();
            System.out.println(" 服务器启动成功，监听端口: " +
                    channelFuture.channel().localAddress());

            // 7 等待通道关闭的异步任务结束
            // 服务监听通道会一直等待通道关闭的异步任务结束
            ChannelFuture closeFuture = channelFuture.channel().closeFuture();
            closeFuture.sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 8 优雅关闭EventLoopGroup，
            // 释放掉所有资源包括创建的线程
            workerLoopGroup.shutdownGracefully();
            bossLoopGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        int port = 12346;
        new DecoderHandlerNettyEchoServer(port).runServer();
    }
}