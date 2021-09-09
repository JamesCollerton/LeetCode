class Solution {
    public int findMin(int[] nums) {
        int firstElement = nums[0];
        int left = 0, right = nums.length - 1;
        
        while(left <= right && (left < nums.length - 1)) {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            else if(nums[mid] < firstElement) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return firstElement;
    }
}