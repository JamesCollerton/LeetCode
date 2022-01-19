class Solution {
    
    public int jump(int[] nums) {
        
        int jumps = 0;
        int currentLevelEnd = 0;
        int currentMax = 0;
        int i = 0;    
        
        while(currentLevelEnd < nums.length - 1 && i < nums.length) {
            currentMax = Math.max(currentMax, i + nums[i]);
            if(i == currentLevelEnd) {
                currentLevelEnd = currentMax;
                jumps++;
            }
            i++;
        }
        
        return jumps;
    }
}