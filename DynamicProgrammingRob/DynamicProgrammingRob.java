class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 1) {
            return nums[0];
        }
        
        int maxTwoBehind = nums[0];
        int maxOneBehind = nums[1];
        
        for(int i = 2; i < nums.length; i++) {
            int value = nums[i];
            
            int newMax = maxTwoBehind + value;
            maxTwoBehind = maxOneBehind > maxTwoBehind ? maxOneBehind : maxTwoBehind;
            maxOneBehind = newMax;
        }
        
        return maxOneBehind > maxTwoBehind ? maxOneBehind : maxTwoBehind;
    }
}