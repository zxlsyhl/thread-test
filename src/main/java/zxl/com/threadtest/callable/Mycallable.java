package zxl.com.threadtest.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Mycallable implements Callable<String> {
    private int a ;

    public Mycallable(int a) {
        this.a = a;
    }

    public String call() throws Exception {
        return "reuslt:"+a;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<Future<String>>();
        for (int i=0;i<5; i++){
            results.add(executorService.submit(new Mycallable(i)));
        }

        System.out.println("begin");

        for(Future<String> fs:results){
            try {
                System.out.println(fs.get());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("end");
    }
}
