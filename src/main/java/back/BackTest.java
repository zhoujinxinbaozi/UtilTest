package back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class BackTest {
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        backtracking(new int[]{1,2,3,4}, 0, 0);
    }
    public static void backtracking(int[] arr, int start, int target){
        if(target == 3){
            System.out.println(Arrays.asList(list).toString());
        }
        for(int i = start; i < arr.length; i++){
//            swap(arr,i,start);
            list.add(arr[i]);
            backtracking(arr, i+1, target+1);
            list.remove(list.size() - 1);
//            swap(arr, i, start);

        }
    }

    public static void swap(int[] arr , int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

