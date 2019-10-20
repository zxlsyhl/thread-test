package zxl.com.threadtest.waitandnotify;

public class WaitNotifyTest1Thread2 implements Runnable {
    static int a = 10;
    @Override
    public void run() {
//        while (true){
            synchronized (WaitNotifyTest1Thread.object){
                for (int i=0;i<10;i++){
                    a--;
                    if(a%5==0){
                        System.out.println(Thread.currentThread().getName()+":唤醒线程时；a="+a);
//                        WaitNotifyTest1Thread.object.notify();
                        WaitNotifyTest1Thread.object.notifyAll();
                        try {
                            Thread.sleep(1000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }

//        }
    }
}
