class Solution {
    public int maxProfit(int[] prices) {
        int total = 0;
        boolean haveStock = false;
        
        for(int i = 0; i < prices.length; i++) {
            if(i + 1 == prices.length) {
                if(haveStock) {
                    total += prices[i];
                    haveStock = false;
                }
            } else if(prices[i] < prices[i + 1]) {
                if(!haveStock) {
                    total -= prices[i];
                    haveStock = true;
                }
            } else if(prices[i] > prices[i + 1]) {
                if(haveStock) {
                    total += prices[i];
                    haveStock = false;
                }
            }
        }
        
        return total;
    }
}