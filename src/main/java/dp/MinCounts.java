package dp;

/***
 * 给定数组arr，所有的数均为正数且不重复，每个值代表一种面值的硬币，每种硬币可以使用任意张，
 * 在给定一个整数aim代表要找的钱数，求组成aim的最小货币数。
 */

/***
 * solution:
 * 生成二维数组result[][], result.length = 给定数组的长度 result[0].length = aim+1
 * result[i][j] 表示只用前i个面值的硬币，组成j的最小货币数
 * 第一列均为零，组成0不需要任何的硬币
 * 第一行
 *      if(i%arr[0] == 0)
 *          result[0][i] = i/arr[0]
 *      else
 *          result[0][i] = Integer.Max_Value
 * 递推公式：result[i][j] = min(dp[i-1][j],dp[i][j-k*arr[i]]+k)
 */
public class MinCounts {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 3};
        getMin(arr, 16);
    }

    private static void getMin(int[] arr, int aim) {
        int[][] result = new int[arr.length][aim+1];
        int row = result.length;
        int col = result[0].length;
        int max = Integer.MAX_VALUE;
        // fill first column(默认即为0)
//        for(int i = 0; i < row; i ++){
//            result[i][0] = 0;
//        }
        // fill first row
        for(int i = 0; i < col; i ++){
            if((i%arr[0]) == 0){
                result[0][i] = i/arr[0];
            }else{
                result[0][i] = Integer.MAX_VALUE;
            }
        }
        // fill global
        for(int i = 1; i < row; i ++){
            for(int j = 1; j < col; j ++){
                int min = Integer.MAX_VALUE;
                if(arr[i] > j){ // current value > 组成的总钱数  及 当前一张都不能用
                    result[i][j] = Math.min(result[i-1][j], min);
                }else{ // can use one or more current value
                    for(int t = 1; t <= j; t ++){
                        int minZhangShu = t/arr[i];
                        if(result[i-1][j-minZhangShu*arr[i]] != Integer.MAX_VALUE){
                            min = Math.min(result[i-1][j-minZhangShu*arr[i]] + minZhangShu, min);
                        }
                    }
                    result[i][j] = min;
                }
            }
        }


        print(result);
    }

    private static void print(int[][] result) {
        for(int[] cells : result) {
            //遍历一维数组中每一个元素
            for(int cell : cells) {
                System.out.print(cell+" ");
            }
            System.out.println();
        }
    }
}
