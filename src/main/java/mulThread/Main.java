package mulThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * 線程池的方式進行時間上的取捨，大於規定時間吐出的結果不要了
 */
public class Main {
    private static ExecutorService pool = Executors.newFixedThreadPool(10);
    private static List<Integer> list = new ArrayList<>();
    private static int noData = 0;
    private static int haveData = 0;
    private static final int count = 20;

    public static void main(String[] args) {
        for (int i = 1; i <= count; i++) {
            Callable callable = new CallableEntity(i);
            Future future = pool.submit(callable);
            try {
                Integer target = (Integer)future.get(i, TimeUnit.MILLISECONDS);
                list.add(target);
            } catch (Exception e) {
//                System.out.println(String.format("notGetData"));
            }
        }
        System.out.println("get data = " + list.size());
        System.out.println(Arrays.asList(list).toString());
        System.exit(0);
    }

}
