package mulThread.signal;

import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static final Lock lock = new ReentrantLock();
    public static final Condition condition = lock.newCondition();
    public static List<Integer> list = new ArrayList<Integer>();

    class producer implements Runnable {

        @Override
        public void run() {
            lock.lock();
            list.add(1);
            System.out.println("list.size() = " + list.size());
            if (list.size() == 10) {
                System.out.println("唤醒。。。");
                condition.signalAll();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        }
    }

    class consumer implements Runnable {
        @Override
        public void run() {
            lock.lock();
            while (list.size() < 10) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            consume(list);
            list = new ArrayList<Integer>();
            lock.unlock();
        }
    }

    public void consume(List<Integer> list) {
        System.out.println(Arrays.asList(list).toString());

//        System.out.println(list.size());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public void start() {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            es.submit(new Thread(new consumer()));
            es.submit(new Thread(new producer()));
        }
    }


}
