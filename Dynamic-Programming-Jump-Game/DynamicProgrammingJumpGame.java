class Solution {
    
    public boolean canJump(int[] nums) {
        
        int max = 0;
        int i = 0;
        
        while(max < nums.length && i <= max) {
            max = Math.max(max, i + nums[i]);
            i++;
        }
                
        return max >= nums.length - 1;
    }
    
}