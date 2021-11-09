class Solution {
    public int numSquares(int n) {        
        
        int[] dp = new int[n + 1];
        
        dp[0] = 0;
        
        for(int i = 1; i <= n; i++) {
            
            int j = 1;
            int min = Integer.MAX_VALUE;
            
            while(j * j <= i) {
                int remainingValue = i - j * j;
                min = min < dp[remainingValue] + 1 ? min : dp[remainingValue] + 1;
                j++;
            }
            
            dp[i] = min;
        }
        
        return dp[n];
    }
}