package base.multithread.threadconection;
/*
 * 实现定时器
 */
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class Task extends TimerTask{
	public void run(){
		System.out.println("定时运行");
	}
}
public class ThreadDemo6 {
	public static void main(String[] args) {
		//创建Timer对象，不是守护线程
		Timer t = new Timer(false);
		t.schedule(new Task(), new Date(),2000);
	}
}

