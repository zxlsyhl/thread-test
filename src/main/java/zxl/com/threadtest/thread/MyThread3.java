package zxl.com.threadtest.thread;

/**
 * 插入公共资源
 */
public class MyThread3 extends Thread {
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("线程"+Thread.currentThread().getName());
        }
    }


    public static void main(String[] args) {
    }

}
