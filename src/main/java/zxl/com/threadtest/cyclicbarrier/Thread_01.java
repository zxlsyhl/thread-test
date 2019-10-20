package zxl.com.threadtest.cyclicbarrier;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 允许一组线程全部等待彼此达到共同屏障点的同步辅助。 循环阻塞在涉及固定大小的线程方的程序中很有用，这些线程必须偶尔等待彼此。 屏障被称为循环
 * ，因为它可以在等待的线程被释放之后重新使用。
 *
 * @author bc
 * @data 2018年9月29日
 */
public class Thread_01 extends Thread {

    private CyclicBarrier cbRef;

    public Thread_01(CyclicBarrier cbRef) {
        super();
        this.cbRef = cbRef;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + "到了!" + System.currentTimeMillis());
            // 等待所有 parties已经在这个障碍上调用了 await 。
            cbRef.await();
            System.out.println(Thread.currentThread().getName() + "完成!");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}