package base.multithread.thread;
/*
 * 创建线程第一种方式
 * 多线程程序的特点
 */

class SubThread extends Thread{
	public void run(){
		for(int i = 0 ; i < 50 ; i++){
			System.out.println("run..."+i);
		}
	}
}

public class ThreadDemo1 {
	public static void main(String[] args) {
		SubThread s = new SubThread();
		s.start();
		for(int i = 0 ; i < 50 ; i++){
			System.out.println("main..."+i);
		}
	}
}
