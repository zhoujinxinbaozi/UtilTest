package dp;

import java.util.Arrays;

/***
 * 最长递增子序列
 */
public class MaxSubsequence {
    public static void main(String[] args) {
        getSubsequence(new int[]{2,1,5,3,6,4,8,9,7});
    }

    //o(n^2)的解法
    private static void getSubsequence(int[] arr) {
        int[] result = new int[arr.length];
        result[0] = 1;
        for(int i = 1; i < arr.length; i ++){
            int count = 1;
            int current = arr[i];
            for(int j = i; j >= 0; j --){
                if(arr[j] < current){
                    count ++;
                    current = arr[j];
                }
            }
            result[i] = count;
        }
        System.out.println(Arrays.toString(result));
    }
}
