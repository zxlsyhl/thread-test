package zxl.com.threadtest.thread;

import zxl.com.threadtest.entity.Money;

/**
 * 插入公共资源
 */
public class MyThread2 extends Thread {
    private int b;

    static int a =0;

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            a++;
            System.out.println("线程："+Thread.currentThread().getName()+"；a:"+a);
        }
    }

    public MyThread2(int b) {
        this.b = b;
    }

    public static void main(String[] args) {
        MyThread2 myThread1 = new MyThread2(1);
        MyThread2 myThread2 = new MyThread2(2);
        myThread1.start();
        myThread2.start();

    }

}
