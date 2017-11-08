package base.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * 服务器发布者
 * @author Administrator
 *
 */
public class RpcExporter {
	static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	public static void exporter(String hostname,int port){
		try {
			ServerSocket server = new ServerSocket();
			server.bind(new InetSocketAddress(hostname, port));
			while(true){
				executor.execute(new ExporterTask(server.accept()));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private static class ExporterTask implements Runnable{
		Socket client = null;
		public ExporterTask(Socket client){
			this.client=client;
		}
		public void run() {
			ObjectInputStream input = null;
			ObjectOutputStream output = null;
			try {
				input= new ObjectInputStream(client.getInputStream());
				String interfaceName = input.readUTF();
//				System.out.println(interfaceName);
				Class<?> service = Class.forName(interfaceName);
				String methodName = input.readUTF();
//				System.out.println(methodName);
				Class<?>[] parameterType = (Class<?>[]) input.readObject();
				Object[] arguments = (Object[]) input.readObject();
				Method method = service.getMethod(methodName, parameterType);
				Object result = method.invoke(service.newInstance(), arguments);
				output = new ObjectOutputStream(client.getOutputStream());
				output.writeObject(result);

			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if (output != null){
					try {
						output.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (input != null){
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (client != null){
					try {
						client.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}
		
	}
}
