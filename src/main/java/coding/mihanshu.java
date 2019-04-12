package coding;

public class mihanshu {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        double result;
        int i = 100000000;
        while(i-- != 0){
            result = calculate3(2, 100000);
//            System.out.println(result);
        }
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        i = 100000000;
        while(i-- != 0){
            result = calculate1(2, 100000);
//            System.out.println(result);
        }
        System.out.println(System.currentTimeMillis() - start);


        start = System.currentTimeMillis();
        i = 100000000;
        while(i-- != 0){
            result = calculate(2, 100000);
//            System.out.println(result);
        }
        System.out.println(System.currentTimeMillis() - start);
//        System.out.println(result);
    }

    // 求a的x次幂
    private static double calculate(int a, int x) {
        boolean b = false;
        if(x > 0){
            b = true;
        }
        x = Math.abs(x);
        if(x == 1){
            return a;
        }else{
            double temp = calculate(a, x/2);
            double result = 0;
            if((x & 1) == 1){
                result = temp * temp * a;
            }else{
                result = temp * temp;
            }
            return b ? result : 1/result;
        }
    }

    // 快速解法，bit的方式
    public static double calculate1(double a, int x){
        double result = 1;
        int count = 0;
        while(x != 0){
            count ++;
            if((x & 1) == 0){
//                a = a * a;
                x = x >> 1;
            }else{
                result = result * a;
//                a = a * a;
                x = x >> 1;
            }
            a *= a;
        }
//        System.out.println("count = " + count);
        return result;
    }

    public static double calculate3(double a, int x){
        double result = a;
        int cc = 0;
        double ss = Math.log(x)/Math.log(2);
        for(int i = 1; i < ss; i ++){
            cc ++;
            if((x & 1) == 1){
                result = result * a * a;
//                System.out.println("result = " + result);
                x = x >> 1;
            }else{
                result = result * a;
                x = x >> 1;
            }
            a *= a;
        }
//        System.out.println("cc = " + cc);
        return result;
    }


}
