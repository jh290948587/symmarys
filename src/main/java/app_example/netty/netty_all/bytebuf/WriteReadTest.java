package app_example.netty.netty_all.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.junit.Test;

/**
 * 创建ByteBuf并写入和读取
 */
public class WriteReadTest {

    @Test
    public void testWriteRead() {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer();
        System.out.println(buffer);
        System.out.printf("动作：写入4个字节 (1,2,3,4)", buffer);
        System.out.println();
        buffer.writeBytes(new byte[]{1, 2, 3, 4});
        System.out.printf("动作：取数据 ByteBuf，不改变索引", buffer);
        getByteBuf(buffer);
        System.out.println(buffer);
        System.out.printf("动作：读完 ByteBuf， 改变索引", buffer);
        readByteBuf(buffer);
        System.out.println(buffer);

    }

    //读取一个字节，不改变指针
    private void getByteBuf(ByteBuf buffer) {
        System.out.println();
        for (int i = 0; i < buffer.readableBytes(); i++) {
            System.out.println("读取一个字节:" + buffer.getByte(i));
        }
    }

    //读取一个字节
    private void readByteBuf(ByteBuf buffer) {
        System.out.println();
        while (buffer.isReadable()) {
            System.out.println("读取一个字节:" + buffer.readByte());
        }
    }
}
