class Solution {
    
    public int jump(int[] nums) {
        
        int jumps = 0;
        int currentLevelEnd = 0;
        int max = 0;
        
        for(int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if(i == currentLevelEnd) {
                jumps++;
                currentLevelEnd = max;
            }
        }
        
        return jumps;
    }
}