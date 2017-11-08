package base.multithread.threadconection;
/*
 * 守护线程
 */
class ThreadDaemon implements Runnable{
	public void run(){
		while(true)
			System.out.println("run...");
	}
}
public class ThreadDemo5 {
	public static void main(String[] args) {
		ThreadDaemon td = new ThreadDaemon();
		Thread t = new Thread(td);
		t.setDaemon(true);
		t.start();
	}
}

	
	
	
	
	
	

	
	
	
