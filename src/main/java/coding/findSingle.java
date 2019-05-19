package coding;

/***
 *  给定一个标准的二维数组，从左到右为增加的，从上到下是增加的
 *  给定一个目标数，判断是否存在，存在返回位置，不存在返回-1，-1
 */
public class findSingle {
    public static void main(String[] args) {
        int[][] arr = {{1,3,7,9},{2,8,10,11},{4,12,14,16},{6,15,17,19}};
        calculate(arr, 17);
    }
    //O(n+m)
    private static void calculate(int[][] arr, int target) {
        int i = 0;
        int j = arr[0].length - 1;
        while(i < arr.length && j >= 0){
            if(arr[i][j] == target){
                System.out.println("i = " + i + "\t" + "j = " + j);
                return ;
            }else if(arr[i][j] < target){
                i ++;
            }else{
                j --;
            }
        }
        System.out.println("i = " + -1 + "\t" + "j = " + -1);
    }
}
