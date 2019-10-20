package zxl.com.threadtest.threadlocal;

public class ThreadlocalTest{
    static ThreadLocal<Integer>  a = new ThreadLocal<Integer>();

    public static void main(String[] args) {
        new Thread(new A()).start();
        new Thread(new B()).start();
        a.set(3);
        System.out.println(Thread.currentThread().getName()+":"+a.get());

    }

    static class A implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<10;i++){
                a.set(1);
                System.out.println(Thread.currentThread().getName()+":"+a.get());
            }
        }
    }

    static class B implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<10;i++){
                a.set(2);
                System.out.println(Thread.currentThread().getName()+":"+a.get());
            }
        }
    }
}
