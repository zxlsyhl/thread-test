2.1 newSingleThreadExecutor 

创建一个单线程的线程池。这个线程池只有一个线程在工作，也就是相当于单线程串行执行所有任务。
如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。此线程池保证所有任务的执行顺序按照任务的提交顺序执行。

补充：核心线程数1，最大线程数1，超时时间为0；使用LinkedBlockingQueue队列。

2.2 newFixedThreadPool

创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。
线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。

补充：核心线程数/最大线程数 实力化时指定，大小相同，超时时间为0；使用LinkedBlockingQueue队列。

2.3 newCachedThreadPool

创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，

那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，此线程池又可以智能的添加新线程来处理任务。
此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。

补充：核心线程数0, 最大线程数Integer.MAX_VALUE，最大空闲时间60秒默认。使用SynchronousQueue队列。

2.4 newScheduledThreadPool

创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。

补充：核心线程数指定，最大线程数Integer.MAX_VALUE，超时时间为0 不失效；使用DelayedWorkQueue。


线程池常用参数
corePoolSize：核心线程数量，会一直存在，除非allowCoreThreadTimeOut设置为true
maximumPoolSize：线程池允许的最大线程池数量
keepAliveTime：线程数量超过corePoolSize，空闲线程的最大超时时间
unit：超时时间的单位，代表keepAliveTime时间单位，可以取下列值：
            TimeUnit.DAYS; //天
        　　TimeUnit.HOURS; //小时
        　　TimeUnit.MINUTES; //分钟
        　　TimeUnit.SECONDS; //秒
        　　TimeUnit.MILLISECONDS; //毫秒
        　　TimeUnit.MICROSECONDS; //微妙
        　　TimeUnit.NANOSECONDS; //纳秒

workQueue：工作队列，保存未执行的Runnable 任务  有以下取值：
  （1）ArrayBlockingQueue：规定大小的BlockingQueue，其构造必须指定大小。其所含的对象是FIFO顺序排序的。
  
  （2）LinkedBlockingQueue：大小不固定的BlockingQueue，若其构造时指定大小，生成的BlockingQueue有大小限制，不指定大小，其大小有Integer.MAX_VALUE来决定。其所含的对象是FIFO顺序排序的。
  LinkedBlockingQueue
  （3）PriorityBlockingQueue：类似于LinkedBlockingQueue，但是其所含对象的排序不是FIFO，而是依据对象的自然顺序或者构造函数的Comparator决定。
  
  （4）SynchronizedQueue：特殊的BlockingQueue，对其的操作必须是放和取交替完成。
threadFactory：创建线程的工厂类，是用来创建线程的。默认new Executors.DefaultThreadFactory();
handler：当线程已满，工作队列也满了的时候，会被调用。被用来实现各种拒绝策略。
    （1）ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。 
　　（2）ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。 
　　（3）ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
　　（4）ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务


二：ThreadPoolExecutor使用
Executors.提供的创建线程池方法底层实现的工具类。可以直接使用此类，通过控制核心参数，创建出自己需要的线程池。