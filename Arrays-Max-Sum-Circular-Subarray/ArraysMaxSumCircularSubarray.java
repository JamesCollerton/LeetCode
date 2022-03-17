class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int total = 0;
        
        int maxSum = nums[0];
        int minSum = nums[0];
        
        int maxRunningCount = 0;
        int minRunningCount = 0;
        
        for(int num: nums) {
                        
            maxRunningCount = Math.max(maxRunningCount + num, num);
            maxSum = Math.max(maxSum, maxRunningCount);
            
            minRunningCount = Math.min(minRunningCount + num, num);
            minSum = Math.min(minSum, minRunningCount);
            
            total += num;
        }
     
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}