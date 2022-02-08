class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        
        for(int i = 0; i < nums.length - 2; i++) {
            int startPointer = i + 1;
            int endPointer = nums.length - 1;
            
            while(startPointer < endPointer) {
                int sum = nums[i] + nums[startPointer] + nums[endPointer];
                if(sum < target) {
                    startPointer++;
                } else {
                    endPointer--;
                }
                if(abs(sum - target) < abs(result - target)) {
                    result = sum;
                }
            }
        }
        
        return result;
    }
    
    private int abs(int value) {
        return value < 0 ? -value : value;
    }
}