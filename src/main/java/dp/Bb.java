package dp;

/***
 * 0 1 背包问题
 * T[i,j] 用前i个物品，组成重量小于等于j的最大值
 * 递推公式 T[i,j] = max(T[i-1,j], T[i-1,j-w[i]] + value[i])
 */
public class Bb {
    public static void main(String[] args) {
        int[] values = new int[]{1, 2, 3};
        int[] weights = new int[]{1, 2, 3};
        findMax(weights, values, 10);
    }

    private static void findMax(int[] weights, int[] values, int cap) {
        int[][] result = new int[weights.length][cap + 1];
        for (int j = 0; j < result[0].length; j++) {
            if (j >= weights[0]) {
                result[0][j] = values[0];
                for (; j < result[0].length; j++) {
                    result[0][j] = values[0];
                }
                break;
            }
        }

        for (int i = 1; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (j < weights[i]) {
                    result[i][j] = result[i - 1][j];
                }else{
                    result[i][j] = Math.max(result[i-1][j-weights[i]] + values[i], result[i-1][j]);
                }
            }
        }

        for(int i = 0; i < result.length; i ++){
            for(int j = 0; j < result[0].length; j ++){
                System.out.print(result[i][j] + "  ");
            }
            System.out.println();
        }
    }


}

