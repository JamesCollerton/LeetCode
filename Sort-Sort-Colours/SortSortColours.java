class Solution {
    public void sortColors(int[] nums) {

        int startPointer = 0;
        int currentPointer = 0;
        
        // 0, 1, 2, 2, 1, 0, 1, 1
        // 0, 0, 2, 2, 1, 1, 1, 1
        while(currentPointer < nums.length) {
            if(nums[currentPointer] == 0) {
                int temp = nums[startPointer];
                nums[startPointer] = nums[currentPointer];
                nums[currentPointer] = temp;
                
                startPointer++;
                currentPointer++;
            } else {
                currentPointer++;
            }
        }
        
        currentPointer = startPointer;
        
        // 0, 0, 2, 2, 1, 1, 1, 1
        while(currentPointer < nums.length) {
            if(nums[currentPointer] == 1) {
                int temp = nums[startPointer];
                nums[startPointer] = nums[currentPointer];
                nums[currentPointer] = temp;
                
                startPointer++;
                currentPointer++;
            } else {
                currentPointer++;
            }
        }
    }
}