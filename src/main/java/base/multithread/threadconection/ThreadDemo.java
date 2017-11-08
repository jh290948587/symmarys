package base.multithread.threadconection;
/*
 * 实现线程通信
 * 两个线程操作同一个资源对象
 */
/*
//定义资源对象
class Resource{
	String name;
	String sex;
	boolean flag ;
}
//定义输入线程，对资源中的成员赋值
class Input implements Runnable{
	private Resource r;
	Input(Resource r){this.r = r;}
	public void run(){
		int i = 0;
		while(true){
		 synchronized(r){
		 //判断标记，标记是true，等待
		 if(r.flag)
			try{r.wait();}catch(Exception e){}

		  if(i%2==0){
			r.name = "张三";
			r.sex = "男";
		  }else{
			r.name = "lisi";
			r.sex = "nv";
		  }
		  i++;
		  //将标记改成true
		  r.flag = true;
		  //唤醒对方线程
		  r.notify();
		 }
		}
	}
}
//定义输出线程output获取值
class Output implements Runnable{
	private Resource r;
	Output(Resource r){this.r = r;}
	public void run(){
		while(true){
		  synchronized(r){
			//判断标记，如果标记是false，没数据，等待
			if(!r.flag)
				try{r.wait();}catch(Exception e){}
			System.out.println(r.name+"..."+r.sex);
			//修改标记为false
			r.flag = false;
			//唤醒对方线程
			r.notify();
		  }
		}
	}
}*/
public class ThreadDemo {
	public static void main(String[] args) {
		/*Resource r = new Resource();
		Input in = new Input(r);
		Output out = new Output(r);
		Thread tin = new Thread(in);
		Thread tout = new Thread(out);
		tin.start();
		tout.start();*/
	}
}
