package zxl.com.threadtest.runnable;

public class MyRunnable implements Runnable {
    private int b;
    static int a = 0;
    private int c;
    public void run() {
        for(int i=0;i<10;i++){
            a++;
            c++;
            System.out.println("线程："+Thread.currentThread().getName()+"；a:"+a+"；c:"+c);

        }
    }

    public MyRunnable(int b) {
        this.b = b;
    }

    public MyRunnable(int b, int c) {
        this.b = b;
        this.c = c;
    }

    public static void main(String[] args) {
        //使用同一个实例开多个线程。
        MyRunnable myRunnable = new MyRunnable(1,0);
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);
        Thread t3 = new Thread(myRunnable);
        t1.start();
        t2.start();
        t3.start();

        //使用多实例开多线程
//        MyRunnable myRunnable = new MyRunnable(1,0);
//        MyRunnable myRunnable2 = new MyRunnable(2,0);
//        MyRunnable myRunnable3 = new MyRunnable(3,0);
//        Thread t1 = new Thread(myRunnable);
//        Thread t2 = new Thread(myRunnable2);
//        Thread t3 = new Thread(myRunnable3);
//        t1.start();
//        t2.start();
//        t3.start();
    }
}
