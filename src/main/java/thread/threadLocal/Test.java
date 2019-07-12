package thread.threadLocal;


import java.util.Random;

public class Test {

    private static final ThreadLocal<Integer>  threadLocal = new ThreadLocal<Integer>();
    private static final Random random = new Random();
    public static void main(String[] args) throws Exception{
        threadLocal.set(random.nextInt(10));
        System.out.println(threadLocal.get());
        System.out.println(Thread.currentThread().getName());
        Thread thread = new Thread(){
            @Override
            public void run() {
                threadLocal.set(random.nextInt(11) + 10);
                System.out.println(threadLocal.get());
                System.out.println(Thread.currentThread().getName());
            };
        };
        thread.start();
        thread.join();
        System.out.println(threadLocal.get());
        System.out.println(Thread.currentThread().getName());
    }
}
