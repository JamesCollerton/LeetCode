class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }
        
        int sell = 0, buy = -prices[0], rest = 0;
        
        for(int i = 0; i < prices.length; i++) {
            int tempSell = sell, tempBuy = buy, tempRest = rest;
            
            buy = Math.max(tempBuy, tempRest - prices[i]);
            sell = Math.max(tempSell, tempBuy + prices[i]);
            rest = Math.max(tempRest, tempSell);
        }
        
        return sell;
    }
}