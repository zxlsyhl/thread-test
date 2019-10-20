package zxl.com.threadtest.waitandnotify;

public class WaitNotifyTest1 {
    public static void main(String[] args) {
        WaitNotifyTest1Thread runable1 = new WaitNotifyTest1Thread();
        WaitNotifyTest1Thread2 runable2 = new WaitNotifyTest1Thread2();
        Thread thread1 = new Thread(runable1);
        Thread thread2 = new Thread(runable1);
        Thread thread3 = new Thread(runable1);
        Thread thread4 = new Thread(runable1);
        Thread thread5 = new Thread(runable1);
        Thread thread6 = new Thread(runable2);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}
