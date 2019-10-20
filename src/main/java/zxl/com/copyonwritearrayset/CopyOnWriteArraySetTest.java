package zxl.com.copyonwritearrayset;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetTest {
    public static void main(String[] args) {
        HelloThread ht = new HelloThread();

        for (int i = 0; i < 10 ; i++) {
            new Thread(ht).start();
        }

    }
    static class HelloThread implements Runnable {

//    private static List<String> list = Collections.synchronizedList(new ArrayList<String>());

        private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();

        static {
            list.add("AA");
            list.add("BB");
            list.add("CC");
        }

        @Override
        public void run() {

            Iterator<String> it = list.iterator();

            while(it.hasNext()) {
                System.out.println(it.next());

                list.add("AA");
            }
        }
    }

}
