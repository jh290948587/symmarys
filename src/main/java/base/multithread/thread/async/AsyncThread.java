package base.multithread.thread.async;

/**
 * Created by Administrator on 2016/12/15.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 多线程执行，异步获取结果
 *
 * @author i-clarechen
 *
 */
public class AsyncThread {

    public static void  main(String[] args) {
        AsyncThread t = new AsyncThread();
        List<Future<String>> futureList = new ArrayList<Future<String>>();
        t.generate(3, futureList);
        System.out.println("主线程完毕");
        System.out.println(Thread.activeCount());
//        t.doOtherThings();
        t.getResult(futureList);

    }

    /**
     * 生成指定数量的线程，都放入future数组
     *
     * @param threadNum
     * @param fList
     */
    public void generate(int threadNum, List<Future<String>> fList) {
        ExecutorService service = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) {
            Future<String> f = service.submit(getJob(i));
            fList.add(f);
        }
        service.shutdown();
    }

    /**
     * other things
     */
    public void doOtherThings() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("do thing no:" + i);
                Thread.sleep(1000 * (new Random().nextInt(10)));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从future中获取线程结果，打印结果
     *
     * @param fList
     */
    public void getResult(List<Future<String>> fList) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(getCollectJob(fList));
        service.shutdown();
    }

    /**
     * 生成指定序号的线程对象
     *
     * @param i
     * @return
     */
    public Callable<String> getJob(final int i) {
        final int time = new Random().nextInt(10);
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000 * time);
                return "thread-" + i;
            }
        };
    }

    /**
     * 生成结果收集线程对象
     *
     * @param fList
     * @return
     */
    public Runnable getCollectJob(final List<Future<String>> fList) {
        return new Runnable() {
            public void run() {
                for (Future<String> future : fList) {
                    try {
                        while (true) {
                            if (future.isDone() && !future.isCancelled()) {
                                System.out.println("Future:" + future
                                        + ",Result:" + future.get());
                                break;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
//                fList.forEach(future -> {
//                    try {
//                        while (true) {
//                            if (future.isDone() && !future.isCancelled()) {
//                                System.out.println("Future:" + future
//                                        + ",Result:" + future.get());
//                                System.out.println("操作是-----------"+Thread.currentThread().getName());
//                                break;
//                            } else {
//                                Thread.sleep(1000);
//                                System.out.println(Thread.currentThread().getName()+"--------------等一会");
//                            }
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                });
            }
        };
    }

}
