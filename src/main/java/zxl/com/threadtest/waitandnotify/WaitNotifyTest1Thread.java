package zxl.com.threadtest.waitandnotify;

public class WaitNotifyTest1Thread implements Runnable {
    static Object object = 1;

    @Override
    public void run() {

        synchronized (object){
            System.out.println(Thread.currentThread().getName()+":获取到锁");
            try {
                object.wait();
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"被唤醒");
        }
    }
}
