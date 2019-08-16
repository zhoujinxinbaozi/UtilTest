package mulThread.demo.service;

import java.util.concurrent.*;

public class Service {
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);
    public static Future future1 = null;
    public static Future future2 = null;
    public static Future future3 = null;

    class Service1 implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "service1";
        }
    }

    class Service2 implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "service2";
        }
    }

    class Service3 implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(10);
            return "service3";
        }
    }

    public void get() {// 顺序执行，当前方法执行完，future不为空，但是里面的内容有可能没返回来
        future1 = executor.submit(new Service1());
        future2 = executor.submit(new Service2());
        future3 = executor.submit(new Service3());
    }

}
