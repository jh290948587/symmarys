//package app_example.netty.netty_all.protocol;
//
//
//import org.junit.Test;
//
//import java.io.IOException;
//
///**
// * create by 尼恩 @ 疯狂创客圈
// **/
//public class JsonMsgDemo {
//
//    //构建Json对象
//    public JsonMsg buildMsg() {
//        JsonMsg user = new JsonMsg();
//        user.setId(1000);
//        user.setContent("疯狂创客圈:高性能学习社群");
//        return user;
//    }
//
//    //序列化 serialization & 反序列化 Deserialization
//    @Test
//    public void serAndDesr() throws IOException {
//        JsonMsg message = buildMsg();
//        //将POJO对象，序列化成字符串
//        String json = message.convertToJson();
//        //可以用于网络传输,保存到内存或外存
//        System.out.println("json:=" + json);
//
//        //JSON 字符串,反序列化成对象POJO
//        JsonMsg inMsg = JsonMsg.parseFromJson(json);
//        System.out.println("id:=" + inMsg.getId());
//        System.out.println("content:=" + inMsg.getContent());
//    }
//
//
//}
