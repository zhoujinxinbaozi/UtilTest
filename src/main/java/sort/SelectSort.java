package sort;

import java.util.Arrays;

/***
 * 从前向后遍历，从当前位置向后查找，找到最小的那个数的索引(下标)，index与当前位置里面的值互换
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 6, 4, 2,7};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        int len = arr.length;
        for(int i = 0; i < len; i ++){
            int minIndex = i;
            for(int j = i + 1; j < len; j ++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
