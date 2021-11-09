class Solution {
    
    private String s1, s2, s3;
    
    private int[][][] dp;
    
    public boolean isInterleave(String s1, String s2, String s3) {
        
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        
        dp = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        
        return recurse(0, 0, 0);
    }
    
    private boolean recurse(int p1, int p2, int p3) {
        
        if(dp[p1][p2][p3] == -1) {
            return false;
        } else if(dp[p1][p2][p3] == 1) {
            return true;
        }
        
        // We've run out of characters from all and we're done!
        if(p1 >= s1.length() && p2 >= s2.length() && p3 >= s3.length()) {
            dp[p1][p2][p3] = 1;
            return true;
        }
        
        // We've still got characters left, but s3 is finished!
        if((p1 < s1.length() || p2 < s2.length()) && p3 >= s3.length()) {
            dp[p1][p2][p3] = -1;
            return false;
        }
        
        // We've not got any characters left, but s3 is not finished!
        if(p1 >= s1.length() && p2 >= s2.length() && p3 < s3.length()) {
            dp[p1][p2][p3] = -1;
            return false;
        }
        
        if(p1 < s1.length() && p2 < s2.length()) {
            
            if(s1.charAt(p1) == s3.charAt(p3) && s2.charAt(p2) == s3.charAt(p3)) {
                
                boolean result = recurse(p1 + 1, p2, p3 + 1) || recurse(p1, p2 + 1, p3 + 1);
                dp[p1][p2][p3] = result ? 1 : -1;
                return result;
                
            } else if(s1.charAt(p1) == s3.charAt(p3)) {
                
                boolean result = recurse(p1 + 1, p2, p3 + 1);
                dp[p1][p2][p3] = result ? 1 : -1;
                return result;
                
            } else if(s2.charAt(p2) == s3.charAt(p3)) {
                
                boolean result = recurse(p1, p2 + 1, p3 + 1);
                dp[p1][p2][p3] = result ? 1 : -1;
                return result;
                
            } else {

                dp[p1][p2][p3] = -1;
                return false;
                
            }
            
        } else if(p1 < s1.length()) {
            
            if(s1.charAt(p1) == s3.charAt(p3)) {
                
                boolean result = recurse(p1 + 1, p2, p3 + 1);
                dp[p1][p2][p3] = result ? 1 : -1;
                return result;
                
            } else {
                dp[p1][p2][p3] = -1;
                return false;
            }
            
        } else if(p2 < s2.length()) {
            
            if(s2.charAt(p2) == s3.charAt(p3)) {
                
                boolean result = recurse(p1, p2 + 1, p3 + 1); 
                dp[p1][p2][p3] = result ? 1 : -1;
                return result;
                
            } else {
                dp[p1][p2][p3] = -1;
                return false;
            }
            
        }
        
        dp[p1][p2][p3] = -1;
        return false;
    }
}