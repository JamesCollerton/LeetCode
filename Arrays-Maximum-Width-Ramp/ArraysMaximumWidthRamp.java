class Solution {
    public int maxWidthRamp(int[] nums) {
        
        int startPointer = 0;
        int maxRamp = 0;
        
        while(startPointer < nums.length) {
            
            int endPointer = nums.length - 1;
            
            if(endPointer - startPointer <= maxRamp) {
                startPointer = nums.length + 1;
            } else {
            
                while(endPointer >= startPointer && endPointer - startPointer > maxRamp) {

                    if(nums[endPointer] >= nums[startPointer]) {
                        // TODO: Can remove this later
                        maxRamp = Math.max(maxRamp, endPointer - startPointer);
                        endPointer = startPointer - 1;
                    } else {
                        endPointer--;
                    }
                    
                }

                startPointer++;
                
            }
            
        }
        
        
        return maxRamp;
    }
}