package base.rpc;

/**
 * 服务端接口
 * @author Administrator
 *
 */
public interface EchoService {
	String echo(String ping);
	String test(String str);
}
