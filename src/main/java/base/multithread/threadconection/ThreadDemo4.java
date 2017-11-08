package base.multithread.threadconection;
/*
 * 线程的停止方式
 */

class ThreadStop implements Runnable{
	private boolean flag = true;
	public void run(){
		while(flag){
		  synchronized(this){	
			  try{
				  this.wait();
				  }
			  catch(InterruptedException e){
				  e.printStackTrace();
				  flag = false;
			  }
			System.out.println("run....");
		  }
		}
	}
	public void setFlag(boolean flag){
		this.flag = flag;
	}
}

public class ThreadDemo4 {
	public static void main(String[] args) {
		ThreadStop ts = new ThreadStop();
		Thread t = new Thread(ts);
		t.start();
		for(int i = 0 ; i < 10000 ; i++){
			if(i == 9999)
				 t.interrupt();
				//ts.setFlag(false);
			System.out.println(i);
		}
	}
}
