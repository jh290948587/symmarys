package base.multithread.threadconection;
/*
 * 优化线程通信代码
 * 成员私有，提供get set方法
 */
class Resource{
	private String name;
	private String sex;
	private boolean flag;
	
	public synchronized void set(String name,String sex){
		if(flag)
			try{this.wait();}catch(Exception e){}
		  this.name = name;
		  this.sex = sex;
		  flag = true;
		  this.notify();
	}
	
	public synchronized void get(){
		if(!flag)
			try{this.wait();}catch(Exception e){}
		 System.out.println(name +"..."+ sex);
		 flag = false;
		 this.notify();
	}
}
class Input implements Runnable{
	private Resource r;
	Input(Resource r){this.r = r;}
	public void run(){
		int i = 0 ;
		while(true){
			if(i%2==0)
				r.set("����", "��");
			else
				r.set("lisi", "nv");
			i++;
		}
	}
}
class Output implements Runnable{
	private Resource r;
	Output(Resource r){this.r =r;}
	public void run(){
		while(true)
			r.get();
	}
}
public class ThreadDemo1 {
	public static void main(String[] args) {
		Resource r = new Resource();
		new Thread(new Input(r)).start();
		new Thread(new Output(r)).start();
	}
}
