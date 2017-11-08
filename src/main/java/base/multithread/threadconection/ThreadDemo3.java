package base.multithread.threadconection;
/*
 * 生产者与消费者
 * 改造成JDK5新特性 Lock接口方式
 */
import java.util.concurrent.locks.*;
//定义产品对象
class Product{
	private String name;
	private int count ;
	private boolean flag;
	//创建Lock接口的实现类对象
	private Lock lock = new ReentrantLock();
	//通过Lock锁对象，产生出两个Condition对象，一个管理生产线程，一个管理消费线程
	private Condition pro = lock.newCondition();
	private Condition cus = lock.newCondition();

	//定义生产的方法
	public  void setPro(String name){
		lock.lock();
		while(flag){
			try{pro.await();}catch(Exception e){}
		}
		this.name =  name +"第 "+count ++;
		System.out.println(Thread.currentThread().getName()+" 生产"+this.name);
		flag = true;
		cus.signal();
		lock.unlock();
	}
	//定义消费的方法
	public  void getPro(){
		lock.lock();
		while(!flag){
			try{cus.await();}catch(Exception e){}
		}
		System.out.println(Thread.currentThread().getName()+" 消费..... "+this.name);
		flag = false;
		pro.signal();
		lock.unlock();
	}
}
//创建生产者，实现Runnable接口
class Make implements Runnable{
	private Product p ;
	Make(Product p){this.p=p;}
	public void run(){
		while(true){
			p.setPro("鼠标");
		}
	}
}
//创建消费者，实现Runnable
class Cust implements Runnable{
	private Product p ;
	Cust(Product p){this.p = p;}
	public void run(){
		while(true){
			p.getPro();
		}
	}
}
public class ThreadDemo3 {
	public static void main(String[] args) {
		Product p = new Product();
		Make m = new Make(p);
		Cust c = new Cust(p);
		Thread t0 = new Thread(m);
		Thread t1 = new Thread(m);
		Thread t2 = new Thread(m);
		Thread t3 = new Thread(m);
		Thread t4 = new Thread(m);
		Thread t5 = new Thread(m);
		Thread t6 = new Thread(c);
		Thread t7 = new Thread(c);
		Thread t8 = new Thread(c);
		Thread t9 = new Thread(c);
		Thread t10 = new Thread(c);
		Thread t11 = new Thread(c);

		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		t11.start();
	}
}