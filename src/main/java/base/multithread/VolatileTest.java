package base.multithread;

/**
 * Created by Administrator on 2017/4/20.
 */
public class VolatileTest {
    public static volatile int race=0;
    public static void increase(){
        race++;
    }
    private static final int THREADS_COUNT=20;
    public void testhaha(){
        String[] as = new String[4];
    }

    public static void main(String[]args){
        Thread[]threads=new Thread[THREADS_COUNT];

        for(int i=0;i<THREADS_COUNT;i++){
            Thread aa=new Thread(new Runnable(){
                @Override
                public void run(){
                    for(int i=0;i<100;i++){
                        increase();
                    }
                }
            });
            aa.start();
        }

//        等待所有累加线程都结束
        while(Thread.activeCount()>1)
        Thread.yield();
        System.out.println(race);
    }

}
