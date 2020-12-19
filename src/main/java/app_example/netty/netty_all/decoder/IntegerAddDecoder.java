package app_example.netty.netty_all.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * create by 尼恩 @ 疯狂创客圈
 **/
public class IntegerAddDecoder
        extends ReplayingDecoder<IntegerAddDecoder.Status> {

    enum Status {
        PARSE_1, PARSE_2
    }

    private int first;
    private int second;

    public IntegerAddDecoder() {
        //构造函数中，需要初始化父类的state 属性，表示当前阶段
        super(Status.PARSE_1);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in,
                          List<Object> out) throws Exception {


        switch (state()) {
            case PARSE_1:
                //从装饰器ByteBuf 中读取数据
                first = in.readInt();
                //第一步解析成功，
                // 进入第二步，并且设置“读指针断点”为当前的读取位置
//                checkpoint方法两个作用：
//                1、设置state属性的值，更新一下当前的状态。
//                2、设置“读断点指针”，指针存档，一旦可读数据不够，就会还原到checkpoint的独断点指针处
                checkpoint(Status.PARSE_2);
                break;
            case PARSE_2:
                second = in.readInt();
                Integer sum = first + second;
                out.add(sum);
                System.out.println("相加的结果：" + sum);
                checkpoint(Status.PARSE_1);
                break;
            default:
                break;
        }
    }
}