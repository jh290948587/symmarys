package base.multithread.thread;
/*
 * 设置和获取线程名字
 */

class ThreadName extends Thread{
	ThreadName(String name){
		super(name);
	}
	public void run(){
		//调用getName()方法
		//System.out.println(getName());

		System.out.println(Thread.currentThread().getName());
	}
}

public class ThreadDemo2 {
	public static void main(String[] args) throws InterruptedException {
		ThreadName name = new ThreadName("线程Thread");
		//name.setName("旺财");
		name.start();
		Thread.sleep(500);
		//静态方法currentThread()获取运行main方法的线程对象
		String threaName = Thread.currentThread().getName();
		System.out.println(threaName);

	}
}
