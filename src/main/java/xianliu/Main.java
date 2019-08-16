package xianliu;

public class Main {
    static final AccessLimitService as = AccessLimitService.getInstance();
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1000);
        long start = System.currentTimeMillis();
        for(int i = 0; i < 100; i ++){
            if(getToken()){
                System.out.print("i = " + i);
                handle();
            }else{
                System.out.println("i = " + i + " be limited");
            }
        }
        System.out.println("spend = " + (System.currentTimeMillis() - start));
    }

    public static void handle(){
        System.out.println(" 逻辑处理");
    }

    // 获取令牌
    public static boolean getToken(){
        return as.tryAcquire();
    }
}
