package zxl.com.concurrentmaplist;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
public class ConcurrentHashMapTest2{

    //get和put两个单独的原子操作，会造成整体的线程不安全
    public void test1() throws InterruptedException {
        final ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String,Integer>();
        map.put("key", 1);

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    int key = map.get("key") + 1; //step 1
                    map.put("key", key);//step 2
                }
            });
        }
        Thread.sleep(3000); //模拟等待执行结束
        System.out.println("------" + map.get("key") + "------");
        executorService.shutdown();
    }

    //使用synchronized加锁。
    public void test2() throws InterruptedException {
        final ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String,Integer>();
        map.put("key", 1);

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    synchronized (map){
                        int key = map.get("key") + 1; //step 1
                        map.put("key", key);//step 2
                    }
                }
            });
        }
        Thread.sleep(3000); //模拟等待执行结束
        System.out.println("------" + map.get("key") + "------");
        executorService.shutdown();
    }

    //使用原子类AtomicInteger
    public void test3() throws InterruptedException {
        final ConcurrentHashMap<String, AtomicInteger> map = new ConcurrentHashMap<String,AtomicInteger>();
        AtomicInteger integer = new AtomicInteger(1);
        map.put("key", integer);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    map.get("key").incrementAndGet();
                }
            });
        }
        Thread.sleep(3000); //模拟等待执行结束
        System.out.println("------" + map.get("key") + "------");
        executorService.shutdown();
    }


    public static void main(String[] args) throws InterruptedException{
//        new ConcurrentHashMapTest2().test1();
//        new ConcurrentHashMapTest2().test2();
        new ConcurrentHashMapTest2().test3();
    }

}