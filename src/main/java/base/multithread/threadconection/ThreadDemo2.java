package base.multithread.threadconection;
/*
 * 生产者与消费者
 * 多生产多消费
 */
/*
//定义产品对象
class Product{
	private String name;
	private int count ;
	private boolean flag;

	//定义生产的方法
	public synchronized void setPro(String name){
		while(flag){
			try{this.wait();}catch(Exception e){}
		}
		  this.name =  name +"第 "+count ++;
		  System.out.println(Thread.currentThread().getName()+" 生产"+this.name);
		  flag = true;
		  this.notifyAll();
	}
	//定义消费的方法
	public synchronized void getPro(){
		while(!flag){
			try{this.wait();}catch(Exception e){}
		}
		 System.out.println(Thread.currentThread().getName()+" 消费..... "+this.name);
		 flag = false;
		 this.notifyAll();
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
*/
public class ThreadDemo2 {
	public static void main(String[] args) {
		/*Product p = new Product();
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
		t11.start();*/
	}
}

