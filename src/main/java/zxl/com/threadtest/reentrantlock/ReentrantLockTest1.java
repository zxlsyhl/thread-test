package zxl.com.threadtest.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1、可重入锁，在持有锁的线程下，可再次获取，释放时依次释放。
 * 2、实现公平锁；非公平锁
 * 3、响应中断获取锁
 * 4、等等？？？？？？？？？？？
 */
public class ReentrantLockTest1 {
    static Lock lock = new ReentrantLock(true); //true公平锁，false非公平锁

    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            new  Thread(new ThreadDemo()).start();
        }
    }

    static class ThreadDemo implements Runnable{
        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            }catch (Exception e){
                e.printStackTrace();
            }
            for(int i=0;i<5;i++){
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"获取锁");
                lock.unlock();
            }
        }
    }

}
