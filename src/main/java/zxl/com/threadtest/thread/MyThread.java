package zxl.com.threadtest.thread;

import zxl.com.threadtest.entity.Money;

/**
 * 插入公共资源
 */
public class MyThread extends Thread {
    private int b;
    private Money money;



    @Override
    public void run() {
        for(int i=0;i<100;i++){
            money.add(1);
            System.out.println("线程"+Thread.currentThread().getName()+";"+money.getYue());
        }
    }

    public MyThread(Money money) {
        this.money = money;
    }

    public MyThread(int b, Money money) {
        this.b = b;
        this.money = money;
    }

    public static void main(String[] args) {
        Money money = new Money(0);
        MyThread myThread1 = new MyThread(1,money);
        MyThread myThread2 = new MyThread(2,money);
//        MyThread myThread3 = new MyThread(money);
//        MyThread myThread4 = new MyThread(money);
        myThread1.start();
        myThread2.start();
//        myThread3.start();
//        myThread4.start();

    }

}
