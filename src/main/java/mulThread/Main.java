package mulThread;


import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Main {
    public static List<String> ll = new ArrayList<String>();
    public static final ExecutorService pool = Executors.newFixedThreadPool(100);
    public static List<Future> futureList = new ArrayList<Future>();

    public static void add(){
        ll.add("11111");
    }

    public static void main(String[] args) {
        for(int i = 0; i < 1; i ++){
            Callable callable = new CallableEntity();
            Future future = pool.submit(callable);
            futureList.add(future);
        }
        for(int i = 0; i < 1; i ++){
            long start = System.currentTimeMillis();
            try{
                futureList.get(i).get(500, TimeUnit.MILLISECONDS);
            }catch(Exception e){

            }
            System.out.println("spend = " + (System.currentTimeMillis() - start));
            System.out.println(Arrays.asList(ll).toString());
        }

    }

}
