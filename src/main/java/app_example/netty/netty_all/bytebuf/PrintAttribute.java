package app_example.netty.netty_all.bytebuf;


import io.netty.buffer.ByteBuf;

/**
 * create by 尼恩 @ 疯狂创客圈
 **/
public class PrintAttribute {

    public static void print(String action, ByteBuf b) {
        System.out.println("after ===========" + action + "============");
        System.out.println("1.0 isReadable(): " + b.isReadable());
        System.out.println("1.1 readerIndex(): " + b.readerIndex());
        System.out.println("1.2 readableBytes(): " + b.readableBytes());
        System.out.println("2.0 isWritable(): " + b.isWritable());
        System.out.println("2.1 writerIndex(): " + b.writerIndex());
        System.out.println("2.2 writableBytes(): " + b.writableBytes());
        System.out.println("3.0 capacity(): " + b.capacity());
        System.out.println("3.1 maxCapacity(): " + b.maxCapacity());
        System.out.println("3.2 maxWritableBytes(): " + b.maxWritableBytes());
    }
}
