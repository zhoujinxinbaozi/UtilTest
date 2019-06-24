package coding;

/***
 * 给定一个数组为局部有序，分为两部分，给定一个目标数target，返回在数组中的下标，没有返回-1
 */
public class FindNumber {
    public static void main(String[] args) {
        int[] temp = new int[]{7,0,1,2,3,4,5,6};
        System.out.println(func(temp, 0,temp.length - 1, 7));
    }
    // 时间复杂度O(logN)
    public static int func(int[] arr, int start, int end, int target){
        int mid = (start + end)/2;
        if(arr[mid] == target){ // 目标值等语中间的值
            return mid;
        }
        if(start > end){ // 在分出的区间内没有找到
            return -1;
        }

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
