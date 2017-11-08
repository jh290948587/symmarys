package base.multithread.thread;

import base.multithread.single.Single1;
/*
 * 多线程并发访问单例模式，懒汉
 */
class ThreadSingle implements Runnable{
	public void run(){
		for(int i = 0 ; i < 20 ; i++){
			Single1 s = Single1.getInstance();
			System.out.println(s);
		}
	}
}

public class ThreadDemo6 {
	public static void main(String[] args) {
		ThreadSingle t = new ThreadSingle();
		Thread t0 = new Thread(t);
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		
		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}
}
