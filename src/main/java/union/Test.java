package union;

import java.util.Arrays;

public class Test {
    private static int[] arr = new int[10];
    static {
        for(int i = 0; i < 10; i ++){
            arr[i] = i;
        }
    }

    public static void add(int a , int b){
        int pid = arr[a];
        int qid = arr[b];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == pid){
                arr[i] = qid;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static boolean judge(int a, int b){
        return arr[a] == arr[b];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
        add(1,2);
        add(3,5);
        add(2,5);
        add(3,6);
//        System.out.println(judge(2,4));
//        System.out.println(Arrays.toString(arr));
    }


}
