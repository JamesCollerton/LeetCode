class Solution {
    
    private boolean[] seen;
    
    public boolean canJump(int[] nums) {
        seen = new boolean[nums.length];
        return dfs(nums, 0);
    }
    
    private boolean dfs(int[] nums, int pos) {
        if(pos == nums.length - 1) {
            return true;
        }
        
        seen[pos] = true;
        
        boolean result = false;
        int steps = nums[pos];
        
        for(int i = 1; i <= steps; i++) {
            if((pos + i) < seen.length && !seen[pos + i]) {
                result = result || dfs(nums, pos + i);
            }
        }
        
        return result;
    }
    
}