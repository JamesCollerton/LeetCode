class Solution {
    public int findMaxLength(int[] nums) {
        
        int[][] dp = new int[nums.length][2];
        
        // Initialise the start with either having one
        // zero or one one.
        if(nums[0] == 0) {
            dp[0][0] = 1;
        } else {
            dp[0][1] = 1;
        }
        
        // Go through all of the numbers, the value at 
        //  dp[i][0] = Number of zero between 0 and i
        //  dp[j][1] = Number of ones between 0 and i
        // Note, this will just be skipped if we have one
        // entry in the array
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == 0) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1];
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + 1;
            }
        }
        
        // These are the total number of zeros/ ones in the
        // entire array.
        int totalNumberOfZero = dp[nums.length - 1][0];
        int totalNumberOfOnes = dp[nums.length - 1][1];
        
        // Initialise the result
        int result = 0;
        
        // Go through all possible windows in the array. 
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                
                // The number of zeros between 0 and i 
                int numberOfZeroBeforeI = i - 1 < 0 ? 0 : dp[i - 1][0];
                int numberOfOnesBeforeI = i - 1 < 0 ? 0 : dp[i - 1][1];
                
                int numberOfZeroAfterJ = j + 1 >= nums.length ? 0 : totalNumberOfZero - dp[j][0];
                int numberOfOnesAfterJ = j + 1 >= nums.length ? 0 : totalNumberOfOnes - dp[j][1];
                
                int numberOfZeroBetweenIAndJ = totalNumberOfZero - numberOfZeroAfterJ - numberOfZeroBeforeI;
                int numberOfOnesBetweenIAndJ = totalNumberOfOnes - numberOfOnesAfterJ - numberOfOnesBeforeI;
                                
                if(numberOfZeroBetweenIAndJ == numberOfOnesBetweenIAndJ) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        
        return result;
    }
}