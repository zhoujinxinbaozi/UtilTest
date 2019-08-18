package mulThread.Automic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);
    private static AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) {
        for(int i = 0; i < 1000; i ++){
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    count.getAndIncrement();
                }
            });
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count = " + count);
        System.exit(0);
    }
}
