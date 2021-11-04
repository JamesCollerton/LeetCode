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
        
        // For every end with A count add one to a, e, i, o, u
        // For every end with E count add one to e, i, o, u
        // ...
        // We want to create a new map every time as we only want
        // strings with length n
        
        while(n > 0) {
            int[] newDp = new int[6];
            for(int l = 0; l < dp[a]; l++) {
                newDp[a] = newDp[a] + 1;
                newDp[e] = newDp[e] + 1;
                newDp[i] = newDp[i] + 1;
                newDp[o] = newDp[o] + 1;
                newDp[u] = newDp[u] + 1;
            }
            for(int l = 0; l < dp[e]; l++) {
                newDp[e] = newDp[e] + 1;
                newDp[i] = newDp[i] + 1;
                newDp[o] = newDp[o] + 1;
                newDp[u] = newDp[u] + 1;
            }
            for(int l = 0; l < dp[i]; l++) {
                newDp[i] = newDp[i] + 1;
                newDp[o] = newDp[o] + 1;
                newDp[u] = newDp[u] + 1;
            }
            for(int l = 0; l < dp[o]; l++) {
                newDp[o] = newDp[o] + 1;
                newDp[u] = newDp[u] + 1;
            }
            for(int l = 0; l < dp[u]; l++) {
                newDp[u] = newDp[u] + 1;
            }
            dp = newDp;
            n--;
        }
        
        return dp[a] + dp[e] + dp[i] + dp[o] + dp[u];
    }
}