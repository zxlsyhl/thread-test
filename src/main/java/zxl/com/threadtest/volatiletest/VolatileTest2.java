package zxl.com.threadtest.volatiletest;

public class VolatileTest2 implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<10000;i++){
            System.out.println(Thread.currentThread().getName()+";a:"+VolatileTest.a);
        }
    }

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        Thread thread1 = new Thread(volatileTest);
        VolatileTest2 volatileTest2 = new VolatileTest2();
        Thread thread2 = new Thread(volatileTest2);
        thread1.start();
        thread2.start();
        
    }
}
