package zxl.com.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 适用于执行时间短。执行任务要比接收任务快，否则会创建大量线程，最终内存溢出。
 */
public class NewCachedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService pool =  Executors.newCachedThreadPool();//使用newCachedThreadPool();创建静态线程池
        for (int j = 1; j <= 10; j++) {

            pool.execute(new MyThread(j));
            try {
                /*
                 * 线程出现休眠时，只有一个线程在执行
                 * 线程没有休眠时，就会出现多个线程并发执行
                 */
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    static class MyThread implements Runnable {//创建一个类实现Runnable接口
        int num;//计数

        public MyThread() {

        }

        public MyThread(int num) {

            this.num = num;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ":" + num);
        }
    }

}
