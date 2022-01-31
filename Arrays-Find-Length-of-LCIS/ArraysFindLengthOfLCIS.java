class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        int max = 1;
        int counter = 1;
        
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < nums[i + 1]) {
                counter++;
            } else {
                max = Math.max(counter, max);
                counter = 1;
            }
        }
        
        max = Math.max(counter, max);
        
        return max;
    }
}