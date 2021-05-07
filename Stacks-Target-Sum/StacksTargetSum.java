class Solution {
        
    public int findTargetSumWays(int[] nums, int target) {
        return addNumber(nums, target, 0);
    }
    
    private int addNumber(int[] nums, int target, int total) {
        if(nums.length == 0) {
            if(target == total) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return addNumber(Arrays.copyOfRange(nums, 1, nums.length), target, total + nums[0]) +
                addNumber(Arrays.copyOfRange(nums, 1, nums.length), target, total - nums[0]);    
        }    
    }
    
    
}