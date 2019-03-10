package dp;

/***
 * 字符串的最小编辑距离
 */

public class Mindis {

    public static void main(String[] args) {
        String str1 = "a,b,1,2,c,d,3";
        String str2 = "a,b,c,d,f";
        minDistance(str1, str2, 5, 3, 2);// 新增，删除和替换最小的代价
    }

    private static void minDistance(String str1, String str2, int ic, int dc, int rc) {
        String[] arr1 = str1.split(",");
        String[] arr2 = str2.split(",");
        int col = arr2.length + 1;
        int row = arr1.length + 1;
        int[][] result = new int[arr1.length+1][arr2.length+1];
        int temp = 0;
        for(int i = 0; i < row; i ++){
            result[i][0] += temp;
            temp += dc;
        }
        temp = 0;
        for(int j = 0; j < col; j ++){
            result[0][j] += temp;
            temp += ic;
        }
        for(int i = 1; i < row; i ++){
            for(int j = 1; j < col; j ++){
                int min = Integer.MAX_VALUE;
                if(arr1[i-1].equals(arr2[j-1])){
                    min = result[i-1][j-1] ;
                }else{
//                    result[i][j] = Math.min(result[i-1][j] + dc, result[i][j-1]);
                    min = result[i-1][j-1] + rc;
                }
                min = Math.min(min, result[i-1][j] + dc);
                min = Math.min(min, result[i][j-1] + ic);
                result[i][j] = min;
            }
        }
        print(result);
    }

    private static void print(int[][] result){
        for(int i = 0; i < result.length; i ++){
            for(int j = 0; j < result[0].length; j ++){
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }
}   