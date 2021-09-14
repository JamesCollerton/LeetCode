class Solution {
    public int[] searchRange(int[] nums, int target) {

        int start = -1, end = -1;
        
        if(nums == null || nums.length == 0) {
            return new int[] {start, end};
        }

        int left = 0, right = nums.length - 1;
        
        while(left <= right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target){ 
                start = mid;
                end = mid;
                while((start - 1) >= 0 && nums[start - 1] == target) {
                    start--;
                }
                while((end + 1) < nums.length && nums[end + 1] == target) {
                    end++;
                }
                return new int[] {start, end};
            }
            else if(nums[mid] < target) { 
                left = mid + 1; 
            }
            else { 
                right = mid - 1; 
            }
        }

        // End Condition: left > right
        return new int[] {start, end};
        
    }
}