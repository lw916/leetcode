class Solution {
    // 超时
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                if(prices[j] - prices[i] > 0){
                    max = Math.max(max, prices[j] - prices[i]);
                }
            }
        }
        return max;
    }

    public int maxProfit1(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int min = prices[0], max = 0;
        for(int i = 1; i < prices.length; i++ ){
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}