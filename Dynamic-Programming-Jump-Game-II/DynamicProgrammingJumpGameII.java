class Solution {
    
    public int jump(int[] nums) {
        
        int[] jumps = new int[nums.length];
        
        for(int i = 0; i < jumps.length; i++) {
            jumps[i] = Integer.MAX_VALUE;
        }
        
        jumps[0] = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(jumps[i] != Integer.MAX_VALUE) {
                for(int j = 1; j <= nums[i]; j++) {
                    if(i + j < jumps.length) {
                        jumps[i + j] = Math.min(jumps[i + j], jumps[i] + 1);
                    }
                }
            }
        }
        
        return jumps[nums.length - 1];
    }
}