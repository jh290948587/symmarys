package base.multithread.thread;
/*
 * 模拟储户的银行存钱功能
 * 让储户调用银行的存钱功能，同时在两个窗口一起存
 */

class Bank{
	private static int sum ;

	//定义存钱方法，钱数作为参数传递
	public static synchronized void add(int money){
		//synchronized(Bank.class){
		 sum = sum + money;
		 System.out.println("sum="+sum);
		//}
	}
}
//储户类，同时存储
class Cust implements Runnable{
	private Bank b = new Bank();
	public void run(){
		for(int i = 0 ; i < 3 ; i++){
			b.add(100);
		}
	}
}

public class ThreadDemo5 {
	public static void main(String[] args) {
		Cust c = new Cust();
		Thread t0 = new Thread(c);
		Thread t1 = new Thread(c);
		t0.start();
		t1.start();
	}
}
