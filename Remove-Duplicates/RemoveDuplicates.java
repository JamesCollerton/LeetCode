class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        
        int p1 = 0;
        int p2 = 1;
        
        while(p2 < nums.length) {
            while(p2 < nums.length && nums[p1] == nums[p2]) {
                p2++;
            }
            if(p2 < nums.length) {
                nums[p1 + 1] = nums[p2];
                p1++;
                p2++;
            }
        }
        
        return p1 + 1;
    }
}