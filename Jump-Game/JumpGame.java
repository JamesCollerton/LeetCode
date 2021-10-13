class Solution {
    
    private int[] memoisation;
    
    public boolean canJump(int[] nums) {
        memoisation = new int[nums.length];
        
        for(int i = 0; i < memoisation.length; i++) {
            memoisation[i] = -1;
        }
        
        return recurse(0, nums);
    }
    
    private boolean recurse(int current, int[] nums) {
        
        if(memoisation[current] != -1) {
            return memoisation[current] == 1;
        }
        
        if(current == nums.length - 1) {
            return true;
        }
        
        int currentValue = nums[current];
        
        for(int i = current + 1; i <= current + currentValue; i++) {
            if(i < nums.length) {
                if(recurse(i, nums)) {
                    memoisation[current] = 1;
                    return true;
                }
            }
        }
        memoisation[current] = 0;
        return false;
    }
}