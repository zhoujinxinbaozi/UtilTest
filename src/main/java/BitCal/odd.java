package BitCal;

/***
 * 给定一个整形的数组，其中只有一个数出现了奇数次，其他都为偶数次，打印这个数
 *
 * 异或运算满足交换律，n^n = 0     n^0 = n
 * 所以将所有的数进行异或运算，最终的结果即为答案
 */
public class odd {
    public static void main(String[] args) {
        int result = printOddTimesNum1(new int[]{8,6,7,6,8,9,7,15,51,15,51});
        System.out.println(result);
    }

    private static int printOddTimesNum1(int[] arr) {
        int result = 0;
        for(int temp : arr){
            result ^= temp;
        }
        return result;
    }
}
