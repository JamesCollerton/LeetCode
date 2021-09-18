class Solution {
    public void rotate(int[] nums, int k) {
        
        // We know that we will end up in the same place
        // so don't need to do anything
        if(k % nums.length == 0) {
            return;
        }
        
        int startIndex = 0;
        int oldIndex = 0;
        int currentValue = nums[0];
        int stepsLeft = nums.length;
        
        while(stepsLeft > 0) {
            
            // Find the new index we are going to, swap the value
            // with the incoming one, then take the old value for
            // the next swap
            int newIndex = (oldIndex + k) % nums.length;
            int tempValue = nums[newIndex];
            nums[newIndex] = currentValue;
            currentValue = tempValue;
            oldIndex = newIndex;
            
            // If we've reached a cycle then we need to manually
            // move on one place
            if(oldIndex == startIndex) {
                startIndex = (startIndex + 1) % nums.length;
                oldIndex = startIndex;
                currentValue = nums[oldIndex];
            }
            
            stepsLeft--;
        }
    }
}