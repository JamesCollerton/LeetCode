class Solution {
    
    private int[] dp;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        // Convert dict to map and find maximum word length
        Set<String> wordSet = new HashSet<>();
        
        // DP for optimisation
        dp = new int[s.length() + 1];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        
        int maxWordLength = 0;
        for(int i = 0; i < wordDict.size(); i++) {
            wordSet.add(wordDict.get(i));
            maxWordLength = Math.max(maxWordLength, wordDict.get(i).length());
        }
        
        // Go through string trying to split it 
        return recurse(s, 0, wordSet, maxWordLength);
    }
    
    private boolean recurse(String s, int pointer, Set<String> wordSet, int maxWordLength) {
                
        // If we've managed to get to the end of the string then we can do it
        if(pointer >= s.length()) {
            dp[pointer] = 1;
            return true;
        }
        
        if(dp[pointer] != -1) {
            return dp[pointer] == 1 ? true : false;
        }
        
        // From the pointer onwards 
        boolean result = false;
        for(int i = 0; i <= maxWordLength + 1; i++) {
            if(!result) {
                if(pointer + i <= s.length()) {
                    String potentialWord = s.substring(pointer, pointer + i);
                    if(wordSet.contains(potentialWord)) {
                        result = result || recurse(s, pointer + i, wordSet, maxWordLength);
                    }
                }
            }
        }
         
        dp[pointer] = result ? 1 : 0;
        return result;
    }
}