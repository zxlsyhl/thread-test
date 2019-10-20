package zxl.com.threadtest.thread;

/**
 * 插入公共资源
 */
public class MyThread3Test{
    private String getStr(){
        MyThread3 myThread3 = new MyThread3();
        myThread3.start();
        return "123123";
    }

    public static void main(String[] args) {
        System.out.println("being");
        new MyThread3Test().getStr();
        System.out.println("end");
    }

}
