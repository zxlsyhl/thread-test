package zxl.com.concurrentmaplist;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest1 implements Runnable {

    public static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();

    @Override
    public void run() {
        String[] person = new String[]{"张三", "李四", "王五"};
        String current = person[new Random().nextInt(person.length)];

        Integer oldValue, newValue;
        while (true) {
            oldValue = map.get(current);
            if (null == oldValue) {
                newValue = 1;
                if (map.putIfAbsent(current, newValue) == null) {
                    break;
                }
            } else {
                newValue = oldValue + 1;
                if (map.replace(current, oldValue, newValue)) {
                    break;
                }
            }
        }

        System.out.println(current + "当前:" + map.get(current));
    }

    public static void main(String[] args) {
        final Map<String,String> m1 = new HashMap<String, String>();
        m1.put("1","2");
        System.out.println(m1);

        final int a =0;


    }

}