class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) {
            return 0;
        }
        
        int smallest = Integer.MAX_VALUE;
        int result = 0;
        
        for(int i = 0; i < prices.length; i++) {
            
            int currentPrice = prices[i];
            
            if(currentPrice < smallest) {
                smallest = currentPrice;
            } else {
                result = result > currentPrice - smallest ? result : currentPrice - smallest;
            }
        }
        
        return result;
    }
}