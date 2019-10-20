package zxl.com.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定大小的线程池
 */
public class NewFixedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<100;i++){
            executorService.execute(new Thread1());
        }
        executorService.shutdown();

    }
    static class Thread1 implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

