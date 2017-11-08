package base.multithread.thread;
/*
 * 死锁案例
 */
//定义类，实现Runnable接口，重写run方法,死循环
//写同步的嵌套
class Dead implements Runnable{
	private boolean b;
	Dead(boolean b){this.b = b;}
	public void run(){
		while(true){
			if(b){
				//进入A房间(同步代码块)获取A锁
				synchronized(LockA.locka){
					System.out.println("if...locka");
					//进入B房间，获取B锁
					synchronized(LockB.lockb){
						System.out.println("if...lockB");
					}
				}
			}else{
				//进入B房间，获取B锁
				synchronized(LockB.lockb){
					System.out.println("else...lockb");
					//进入A房间，获取A锁
					synchronized(LockA.locka){
						System.out.println("else...locka");
					}
				}
			}
		}
	}
}

public class DeadLockDemo {
	public static void main(String[] args) {
		Dead d1 = new Dead(true);
		Dead d2 = new Dead(false);
		Thread t1 = new Thread(d1);
		Thread t2 = new Thread(d2);

		t2.start();
		t1.start();
	}
}

//定义两个对象锁，A锁，B锁
class LockA{
	private LockA(){}
	public static final LockA locka = new LockA();
}
class LockB{
	private LockB(){}
	public static final LockB lockb = new LockB();
}
