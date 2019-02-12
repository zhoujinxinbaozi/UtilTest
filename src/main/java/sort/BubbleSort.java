package sort;

import java.util.Arrays;

/***
 * 冒泡排序
 *  从当前位置向后查找，如果arr[i+1] < arr[i] 则进行交换，每一趟循环都可以找到当前数组的最大值
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 6, 4, 2,7};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void bubbleSort(int[] arr) {
        int len = arr.length;
        for(int i =0; i < len; i ++){
            for(int j = 0; j < len - i - 1; j ++){
                if(arr[j] > arr[j+1]){
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
            System.out.println(" i = " + i + "  " + Arrays.toString(arr));
        }

    }
}
