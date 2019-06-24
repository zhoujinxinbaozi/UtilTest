package xianliu;

import scala.collection.parallel.ParIterableLike;

import java.util.List;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 滑动窗口
 */
public class LimitService1 {
    public static LimitService1 LimitService1 = new LimitService1();
    public static List<Integer> list = new ArrayList<Integer>();
    private int limtCount = 60;// 限制最大访问的容量
    private static long start = System.currentTimeMillis();// 获取当前系统时间
    private int interval = 60;// 间隔时间60秒
    static CountDownLatch  countDownLatch = new CountDownLatch(10000000);
    static int count = 0;

    public synchronized boolean acquire() {
        long newTime = System.currentTimeMillis();
//        System.out.println("ppp = " + (newTime - start));
        boolean isXL = false;// 是否被限流的标志位
        if (newTime > (start + interval/6)) {
            // 判断是否是一个周期
            start = newTime;
            list.remove(0);
            list.add(0);
            isXL = dealQuery(list);
//            System.out.println(list.size() + "  11" + "\t" + list.toString());
            count ++;
            countDownLatch.countDown();
            return true;
        }
        isXL = dealQuery(list);
//        System.out.println(list.size() + "  22" + "\t" + list.toString());
        countDownLatch.countDown();
        return isXL;
    }

    private boolean dealQuery(List<Integer> list) {
        for(int i = 0; i < list.size(); i ++){
            if(list.get(i) < 10){
                int tmp = list.get(i) + 1;
                list.remove(i);
                list.add(i, tmp);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        init();
        long start1 = System.currentTimeMillis();// 线程执行的起始时间
        List<String> listXL = new ArrayList<String>();// 限流的集合
        List<String> listNXL = new ArrayList<String>();// 非限流的集合
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        start = System.currentTimeMillis();
        for (int i = 1; i <= 10000000; i++) {
            newCachedThreadPool.execute(new Runnable() {
                public void run() {
                    if (LimitService1.acquire()) {
                        listNXL.add("1");
                    } else {
                        listXL.add("2");
                    }
                }
            });
        }
        countDownLatch.await();
        System.out.println("ssss = " + (System.currentTimeMillis() - start1));
        System.out.println(listNXL.size());
        System.out.println(listXL.size());
        System.out.println(count);// 切换桶的次数
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
    // 初始化窗口
    public static void init(){
        for(int i = 0; i < 6; i ++){
            list.add(0);
        }
    }

}
