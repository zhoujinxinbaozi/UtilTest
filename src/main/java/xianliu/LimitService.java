package xianliu;


import java.util.List;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 计数器的方式实现限流
 */
public class LimitService {
    static LimitService limitService = new LimitService();
    private int limtCount = 60;// 限制最大访问的容量
    AtomicInteger atomicInteger = new AtomicInteger(0); // 每秒钟 实际请求的数量
    private long start = System.currentTimeMillis();// 获取当前系统时间
    private int interval = 60;// 间隔时间60秒
    static final int qql_1 = 100;
    static final int qql_2 = 300;


    public boolean acquire() {
        long newTime = System.currentTimeMillis();
        if (newTime > (start + interval)) {
            // 判断是否是一个周期
            start = newTime;
            atomicInteger.set(0); // 清理为0
            return true;
        }
        atomicInteger.incrementAndGet();// i++;
        return atomicInteger.get() <= limtCount;
    }



    public static void main(String[] args){
        List<String> listXL = new ArrayList<String>();
        List<String> listNXL = new ArrayList<String>();
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        long start = System.currentTimeMillis();
        for (int i = 1; i < 10000; i++) {
            if(i == qql_1 || i == qql_2){
                try {
                    Thread.sleep(100);
                    System.out.println("总耗时：" + (System.currentTimeMillis() - start));
                    System.out.println("限流的量为 ：" + listXL.size());
                    System.out.println("未被限流的量为 ：" + listNXL.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            newCachedThreadPool.execute(new Runnable() {
                public void run() {
                    if (limitService.acquire()) {
//                        System.out.println("你没有被限流,可以正常访问逻辑 i:" + tempI);
                        listNXL.add("1");
                    } else {
//                        System.out.println("你已经被限流呢  i:" + tempI);
                        listXL.add("2");
                    }
                }
            });
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
