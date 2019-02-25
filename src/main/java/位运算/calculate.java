package 位运算;

/***
 * 求一个整数的二进制表达式中有多少个1
 *
 * 整数n每次进行无符号右移，检测最右边的bit是否为1来进行统计 count
 * count2 n&n-1 相当于去掉二进制中的最后一位1
 */
public class calculate {
    public static void main(String[] args) {
        System.out.println(count(6));
        System.out.println(count2(6));
    }

    private static int count2(int n) {
        int count = 0;
        while(n != 0){
            n &= (n-1);
            count ++;
        }
        return count;
    }

    private static int count(int n) {
        int count = 0;
        while(n != 0){
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }
}
