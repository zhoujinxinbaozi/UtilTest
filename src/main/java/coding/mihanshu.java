package coding;

public class mihanshu {
    public static void main(String[] args) {
        double result = calculate(2, 3);
        System.out.println(result);
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
                result =  temp * temp * a;
            }else{
                result = temp * temp;
            }
            return b ? result : 1/result;
        }
    }
}
