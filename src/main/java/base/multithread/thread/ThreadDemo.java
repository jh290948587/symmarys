package base.multithread.thread;
/*
 * 单线程程序
 * 程序从main开始，一条路走到死
 */
class Demo{
	public void show(){
		for(int i = 0 ; i < 50 ; i++){
			System.out.println("show..."+i);
		}
	}
}
public class ThreadDemo {
	public static void main(String[] args) {
		new Demo().show();
		for(int i = 0 ; i < 50 ; i++){
			System.out.println("main..."+i);
		}
	}
}
