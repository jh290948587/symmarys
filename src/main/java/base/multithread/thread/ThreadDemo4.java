package base.multithread.thread;

/*
 * 售票案例
 * 4个窗口售票
 * 创建线程的方式，修改成第二种，实现接口方式
 */
//定义类，实现Runnable接口，重写run方法
class Ticket implements Runnable {
	private int tickets = 100;
	private Object obj = new Object();

	public void run() {
		while (true) {
			synchronized (obj) {
				if (tickets > 0) {
					try {
						Thread.sleep(10);
					} catch (Exception e) {

					}
					System.out.println(Thread.currentThread().getName()
							+ " 出售第 " + tickets--);
				}
			}
		}
	}
}

public class ThreadDemo4 {
	public static void main(String[] args) {
		// 创建Thread类的对象，传递Runnable接口的实现类对象
		Ticket t = new Ticket();
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
