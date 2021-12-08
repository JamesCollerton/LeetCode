class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        int p1 = 0;
        int p2 = 0;
        
        int maxLength = 0;
        int min = nums[p1];
        int max = nums[p1];
        
        while(p2 < nums.length) {
            
            boolean valid = true;
            for(int i = p1; i < p2; i++) {
                valid = valid && (Math.abs(nums[i] - nums[p2]) <= limit);
            }
            
            if(valid) {
                maxLength = Math.max(maxLength, p2 - p1 + 1);
                p2++;
            } else {
                p1++;
            }
        }
        
        return maxLength;
    }
}