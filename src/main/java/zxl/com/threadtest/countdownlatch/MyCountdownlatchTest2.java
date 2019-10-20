package zxl.com.threadtest.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyCountdownlatchTest2 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        CountDownLatch cdl = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            CountRunnable runnable = new CountRunnable(cdl);
            pool.execute(runnable);
        }
    }
}
