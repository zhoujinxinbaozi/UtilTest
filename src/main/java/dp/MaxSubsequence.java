package dp;

import java.util.Arrays;


/***
 * 最长递增子序列
 */
public class MaxSubsequence {
    public static void main(String[] args) {
        getSubsequence(new int[]{8,9,7,9,3,4,6,2,4});
        new MaxSubsequence().getSubsequence1(new int[]{8,9,7,9,3,4,6,2,4});
    }

    //o(n^2)的解法
    // i位置的值为，i之前的所有的值小于当前值得最大+1
    private static void getSubsequence(int[] arr) {
        int[] result = new int[arr.length];
        result[0] = 1;
        for(int i = 1; i < arr.length; i ++){
            result[i] = 1;
            for(int j = i - 1; j >= 0; j --){
                if(arr[j] < arr[i]){
                    result[i] = Math.max(result[i],result[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(result));
    }

    /***
     * 8,9,7,9,3,4,6,2,4
     * 8
     * 8 9
     * 7 9
     * 3 9
     * 3 4
     * 3 4 6
     * 2 4 6
     * 最后最长为3
     * result存放的元素为当前长度的最小末尾
     * 遍历的值小于result[0] 直接替换
     * 遍历的值小于result[len] 直接添加
     * 其他情况直接二分查找之前的元素，将第一个比该值大的元素进行替换
     * @param arr
     */
    public void getSubsequence1(int[] arr){
        int len = 1;
        int[] result = new int[arr.length];
        result[0] = arr[0];// 存放当前长度的最小末尾的数
        for(int i = 1; i < arr.length; i ++){
            if(arr[i] > result[len - 1]){
                result[len] = arr[i];
                len ++;
            }else if(arr[i] < result[0]){
                result[0] = arr[i];
            }else{
                swap(result, 0, len -1, arr[i]);
            }
        }
        System.out.println("len = " + len);
        System.out.println(Arrays.toString(result));
    }

    public void swap(int[] arr, int start , int end, int target){
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] < target && arr[mid + 1] > target){
                arr[mid + 1] = target;
                return;
            }else if(arr[mid] < target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
    }
}
