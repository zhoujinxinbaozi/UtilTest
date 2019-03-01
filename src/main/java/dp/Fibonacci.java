package dp;

public class Fibonacci {

    public static void main(String[] args) {
        int result  = f1(8);
        System.out.println(result);
    }



    /***
     * O(n) 斐波那契数列的解法
     * @param n
     * @return
     */
    private static int f1(int n) {
        if(n == 1 || n ==2)
            return 1;
        else{
            int pre1 = 1;
            int pre2 = 1;
            int result = 0;
            for(int i = 3; i <= n; i ++){
                result = pre1 + pre2;
                pre1 = pre2;
                pre2 = result;
            }
            return result;
        }
    }
}
