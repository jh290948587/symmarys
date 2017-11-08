package base.multithread.thread.async;

/**
 * Created by Administrator on 2017/4/13.
 */
public class JavaVMStackOOM {
    private void dontStop(){
        while(true){
        }
    }

    public void stackLeakByThread(){
        while(true){
            Thread thread=new Thread(new Runnable(){
                @Override public void run(){
                    dontStop();
                }
            });
            thread.start();
        }
    }
    public static void main(String[]args)throws Throwable{
        JavaVMStackOOM oom=new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}
