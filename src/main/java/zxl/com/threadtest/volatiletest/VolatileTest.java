package zxl.com.threadtest.volatiletest;

public class VolatileTest implements Runnable{
    volatile static int a = 0;
    private int b =0;
    @Override
    public void run() {
        for(int i=0;i<10000;i++){
            a++;
            b++;
            System.out.println(Thread.currentThread().getName()+";a:"+a+";b:"+b);
        }
    }
}
