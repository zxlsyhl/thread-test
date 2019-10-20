package zxl.com.threadtest.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class MyCountdownlatchTest1 {
    public static void main(String[] args) {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(2);

        for(int i=0; i<3; i++){
            Thread thread = new Thread(new Player(begin,end),String.valueOf(i));
            thread.start();
        }

        try{
            System.out.println("the race begin");
            begin.countDown();
            end.await();//await() 方法具有阻塞作用，也就是说主线程在这里暂停
            System.out.println("the race end");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
