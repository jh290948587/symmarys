package base.rpc;

import java.net.InetSocketAddress;

/**
 * Created by Administrator on 2016/11/18.
 */
public class RpcTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                RpcExporter.exporter("localhost",8088);
            }
        }).start();
        RpcImporter<EchoService> importer = new RpcImporter<>();
        EchoService e = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8088));
        //System.out.println(e.test("love"));
        System.out.println(e.echo("Are you ok ? "));
        System.out.println(e.echo("Are you ok ok? "));

    }
}
