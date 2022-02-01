class Solution {
    public int removeElement(int[] nums, int val) {
        int jumpSize = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                jumpSize++;
            } else {
                nums[i - jumpSize] = nums[i];
            }
        }
        return nums.length - jumpSize;
    }
}