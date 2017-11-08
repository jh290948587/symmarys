package base.multithread.threadconection;
/*
 * 静态方法yield
 * 线程让步
 */
class ThreadYield implements Runnable{
	public void run(){
		for(int i = 0 ; i < 50 ; i++){
			Thread.yield();
			System.out.println(Thread.currentThread().getName()+"..."+i);
		}
	}
}
public class ThreadDemo9 {
	public static void main(String[] args) {
		ThreadYield ty = new ThreadYield();
		new Thread(ty).start();
		new Thread(ty).start();
	}
}
