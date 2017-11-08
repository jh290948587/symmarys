package base.multithread.threadconection;
/*
 * join等待线程终止
 */
class ThreadJoin implements Runnable{
	public void run(){
		for(int i = 0 ; i < 50 ; i++){
			System.out.println(Thread.currentThread().getName()+"..."+i);
		}
	}
}
public class ThreadDemo8 {
	public static void main(String[] args) throws Exception{
		ThreadJoin tj = new ThreadJoin();
		Thread t0 = new Thread(tj);
		Thread t1 = new Thread(tj);
		t0.start();
		t0.join();
		t1.start();
		for(int i = 0 ; i < 50 ; i++){
			System.out.println("main..."+i);
		}
	}
}
