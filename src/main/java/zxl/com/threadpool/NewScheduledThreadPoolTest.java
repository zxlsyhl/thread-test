package zxl.com.threadpool;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 可实现 1）表示延迟3秒执行。
 * ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
 * scheduledThreadPool.schedule(new Runnable() {
 *
 * @Override
 * public void run() {
 * System.out.println("delay 3 seconds");
 * }
 * }, 3, TimeUnit.SECONDS);
 *
 *
 *
 */
public class NewScheduledThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

        scheduleAtFixedRate(service,1000);
        scheduleAtFixedRate(service,6000);

        scheduleWithFixedDelay(service,1000);
        scheduleWithFixedDelay(service,6000);


    }


    private static void scheduleAtFixedRate(ScheduledExecutorService service, final int sleepTime){
        /**
         * scheduleAtFixedRate参数说明。按指定频率周期执行某个任务。 例如：初始化延迟0ms开始执行，每隔100ms重新执行一次任务。
         * command：执行线程
         * initialDelay：初始化延时
         * period：两次开始执行最小间隔时间
         * unit：计时单位
         */
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                long start = new Date().getTime();
                System.out.println("scheduleAtFixedRate 开始执行时间:" +
                        DateFormat.getTimeInstance().format(new Date()));
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long end = new Date().getTime();
                System.out.println("scheduleAtFixedRate 执行花费时间=" + (end -start)/1000 + "m");
                System.out.println("scheduleAtFixedRate 执行完成时间："
                        + DateFormat.getTimeInstance().format(new Date()));
                System.out.println("======================================");
            }
        },1000,5000, TimeUnit.MILLISECONDS);
    }

    private static void scheduleWithFixedDelay(ScheduledExecutorService service,final int sleepTime){
        /**
         * scheduleWithFixedDelay原型定义及参数说明 按指定频率间隔执行某个任务。 例子：初始化时延时0ms开始执行，本次执行结束后延迟100ms开始下次执行。
         * command：执行线程
         * initialDelay：初始化延时
         * period：前一次执行结束到下一次执行开始的间隔时间（间隔执行延迟时间）
         * unit：计时单位
         */
        service.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                long start = new Date().getTime();
                System.out.println("scheduleWithFixedDelay 开始执行时间:" +
                        DateFormat.getTimeInstance().format(new Date()));
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long end = new Date().getTime();
                System.out.println("scheduleWithFixedDelay执行花费时间=" + (end -start)/1000 + "m");
                System.out.println("scheduleWithFixedDelay执行完成时间："
                        + DateFormat.getTimeInstance().format(new Date()));
                System.out.println("======================================");
            }
        },1000,5000,TimeUnit.MILLISECONDS);
    }
}
