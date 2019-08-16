package test;

class Solution {
    public static void main(String[] args) {
        // [7,1,5,3,6,4]
        int[] arr = new int[]{7,1,5,3,6,4};
        System.out.println(new Solution().maxProfit(arr));
    }
    public int maxProfit(int[] prices) {
        return getMax(prices);
    }
    
    public int getMax(int[] prices){
        int len = prices.length;
        int[] curBeforeMin = new int[len];
        curBeforeMin[0] = Integer.MAX_VALUE;
        curBeforeMin[1] = prices[0];
        int min = prices[0];
        for(int i = 2; i < len; i ++){
            if(prices[i-1] < min){
                min = prices[i-1];
                curBeforeMin[i] = min;
            }else{
                curBeforeMin[i] = min;
            }
        }
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < len; i ++){
            result = Math.max(result, prices[i] - curBeforeMin[i]);
        }
        return result;
    }
}