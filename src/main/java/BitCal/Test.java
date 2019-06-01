package BitCal;

/***
 * 用位运算实现加减乘除
 */
public class Test {
    public static void main(String[] args) {
        int sum = add(3, 78);
        int reverse = reverse(4);
        int minus = minus(3, 4);
        System.out.println(minus);
    }
    //求两个数相减的结果
    private static int minus(int a, int b) {
        return add(a,reverse(b));
    }

    // 求给定一个数的相反数(一个数的相反数即当前数取反加1的结果)
    private static int reverse(int i) {
        return add(~i, 1);
    }

    // 实现加法
    private static int add(int a, int b) {
        int sum = 0;
        while( b != 0 ){
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }
    
    

}
