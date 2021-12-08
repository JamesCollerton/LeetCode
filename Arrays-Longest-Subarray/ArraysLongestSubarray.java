class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        int p1 = 0;
        int p2 = 0;
        
        int maxLength = 0;
        
        int min = nums[p1];
        int max = nums[p1];
                
        while(p2 < nums.length) {
                        
            boolean valid = (Math.abs(min - nums[p2]) <= limit) && 
                            (Math.abs(max - nums[p2]) <= limit);
                        
            if(valid) {
                
                maxLength = Math.max(maxLength, p2 - p1 + 1);
                
                max = Math.max(max, nums[p2]);
                min = Math.min(min, nums[p2]);
                                
                p2++;
                
            } else {
                
                p1++;
                                
                max = nums[p1];
                min = nums[p1];
                
                for(int i = p1; i < p2; i++) {
                    max = Math.max(max, nums[i]);
                    min = Math.min(min, nums[i]);
                }
                
            }
        }
        
        return maxLength;
    }
}