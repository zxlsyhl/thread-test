package zxl.com.collectionssynchronizedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CollectionsSynchronizedListTest {
    static List<String> a = new ArrayList<String>();

    static List<String> b = Collections.synchronizedList(new ArrayList<String>());

    static class T1 implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<10000;i++) {
                a.add("i");
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    static class T2 implements Runnable{
        @Override
        public void run() {
            for (String str : a){
                System.out.println(str);
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i=0;i<10;i++){
            executorService.submit(new T1());
        }
        for (int i=0;i<10;i++){
            executorService.submit(new T2());
        }
        executorService.shutdown();
    }
}
