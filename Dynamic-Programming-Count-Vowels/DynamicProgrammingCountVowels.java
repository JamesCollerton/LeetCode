class Solution {
    
    private int[] dp;
    private final int a = 0, e = 1, i = 2, o = 3, u = 4;
    
    public int countVowelStrings(int n) {
        
        dp = new int[6];
        
        dp[a] = 1;
        dp[e] = 1;
        dp[i] = 1;
        dp[o] = 1;
        dp[u] = 1;
        
        n--;
        
        while(n > 0) {
            int[] newDp = new int[6];
            newDp[a] = dp[a];
            newDp[e] = dp[a] + dp[e];
            newDp[i] = dp[a] + dp[e] + dp[i];
            newDp[o] = dp[a] + dp[e] + dp[i] + dp[o];
            newDp[u] = dp[a] + dp[e] + dp[i] + dp[o] + dp[u];
            dp = newDp;
            n--;
        }
        
        return dp[a] + dp[e] + dp[i] + dp[o] + dp[u];
    }
}