package zxl.com.concurrentmaplist;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CollectionsSynchronizedMapTest {
    static Map<String,String> map = Collections.synchronizedMap(new HashMap<String, String>());
    static Map<String,String> map2 = new HashMap<String, String>();

    static class T1 implements Runnable{
        @Override
        public void run() {
            map.put("1",Thread.currentThread().getName());
            System.out.println("11111----"+Thread.currentThread().getName()+":"+map.get("1"));

            map2.put("2",Thread.currentThread().getName());
            System.out.println("22222----"+Thread.currentThread().getName()+":"+map2.get("2"));
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i =0; i<10000;i++){
            service.execute(new T1());
        }
        service.shutdown();
    }
}
