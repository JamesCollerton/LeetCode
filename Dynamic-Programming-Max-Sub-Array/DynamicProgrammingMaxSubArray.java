class Solution {
    public int maxSubArray(int[] nums) {
        
        int max = nums[0];
        int currentMax = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int value = nums[i];
            if(value > value + max) {
                max = value;
            } else {
                max += value;
            }
            
            if(max > currentMax) {
                currentMax = max;
            }
        }
        
        return currentMax;
    }
}