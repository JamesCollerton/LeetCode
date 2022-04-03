class Solution {
    
    private int[][] dp;
    private Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
    
    public int findTheLongestSubstring(String s) {
                    
        int max = 0;
        int n = s.length();
        dp = new int[n + 1][n + 1];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        
        for(int i = 0; i < s.length(); i++) {
            max = Math.max(max, dfs(s, i, 0, 0, new HashSet<>()));
        }
        
        return max;
    }
    
    private int dfs(String s, int i, int count, int max, HashSet<Character> set) {
        
        if(dp[i][count] != -1) {
            return dp[i][count];
        }
        
        if(i >= s.length()) {
            return max;
        }
                        
        char c = s.charAt(i);
        if(vowels.contains(c)) {
            if(set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        
        int newMax = (set.isEmpty() && count + 1 > max) ? count + 1 : max;
                
        newMax = Math.max(newMax, dfs(s, i + 1, count + 1, newMax, set));
        
        dp[i][count] = newMax;
        
        return newMax;
    }
}