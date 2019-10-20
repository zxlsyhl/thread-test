package zxl.com.threadtest.nochange;

/**
 * final修饰的类型不可变，在多线程中安全。
 */
public class NochangeTest implements Runnable{
    private String a = "";
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            a =a+"b";
            System.out.println(Thread.currentThread().getName()+":"+a);
        }
    }

    public static void main(String[] args) {
        NochangeTest nochangeTest = new NochangeTest();
        Thread thread = new Thread(nochangeTest);
        Thread thread2 = new Thread(nochangeTest);
        Thread thread3 = new Thread(nochangeTest);
        thread.start();
        thread2.start();
        thread3.start();
    }
}
