package coding;

/**
 * 给定一个局部有序的数组，给定一个target，找到是否在数组中出现过，出现返回index，没有返回-1
 */
public class FindValue {
    public static void main(String[] args){
        int[] temp = new int[]{7,0,1,2,3,4,5,6};
        System.out.println(func(temp, 0,temp.length - 1, 7));
    }


    // 时间复杂度O(logN)
    public static int func(int[] arr, int start, int end, int target){
        int mid = (start + end)/2;
        if(arr[mid] == target){ // 目标值等于中间的值
            return mid;
        }
        if(start > end){ // 在分出的区间内没有找到
            return -1;
        }

        // 以二分的方法进行切割，总会有一半是有序的
        if(arr[start] < arr[mid]){ // 从start到mid是有序的
            if(arr[start] <= target && target < arr[mid]){ //并且要找的值在这个范围内
                return func(arr, start, mid - 1, target);
            }else{
                return func(arr, mid + 1, end, target); // 剩下的另一半
            }
        }else{ // mid到end是有序的
            if(arr[mid] < target && target <= arr[end]){ //并且要找的值在这个范围内
                return func(arr, mid + 1, end, target);
            }else{
                return func(arr, start, mid - 1, target); // 剩下的另一半
            }
        }
    }

}
