package base.multithread.threadconection;

/*
 * Thread类的方法toString
 */
class ThreadToString implements Runnable{
	public void run(){
		for(int i = 0 ; i < 50 ; i++){
			System.out.println(Thread.currentThread().getName()+"..."+i);
		}
	}
}

public class ThreadDemo7 {
	public static void main(String[] args) {
		ThreadToString tts = new ThreadToString();
		Thread t0 = new Thread(tts);
		Thread t1 = new Thread(tts);
		t0.setPriority(Thread.MAX_PRIORITY);
		t1.setPriority(Thread.MIN_PRIORITY);
		t0.start();
		t1.start();
		//System.out.println(t.toString());
	}
}
