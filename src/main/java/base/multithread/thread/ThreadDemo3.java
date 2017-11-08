package base.multithread.thread;
/*
 * 多线程模拟4个窗口，同时售票
 */
class Tickets implements Runnable {
	private int tickets = 100;
	public void run(){
		while(true){
			synchronized (this) {
				if (tickets > 0) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "卖出" + tickets--);
				}
			}
		}
	}
}
//class Ticket extends Thread{
//	private  int tickets = 100;
//	public void run(){
//		while(true){
//			if(tickets > 0){
//				System.out.println(getName()+"   出售第 "+tickets--);
//			}
//		}
//	}
//}

public class ThreadDemo3 {
	public static void main(String[] args) {
		//创建4个线程
		Tickets tt = new Tickets();
		Thread t0 = new Thread(tt);
		Thread t1 = new Thread(tt);
		Thread t2 = new Thread(tt);
		Thread t3 = new Thread(tt);
		
		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}
}
