class Solution {
    public int search(int[] nums, int target) {
        // Check if just do normal search
        if(nums[0] < nums[nums.length - 1]) {
            // System.out.println("Detected doing normal search");
            return normalSearch(nums, target, 0, nums.length - 1);
        }
        
        // System.out.println("Doing pivot search");
        // Do pivot search
        return pivotSearch(nums, target, 0, nums.length - 1);
    }
    
    private int pivotSearch(int[] nums, int target, int left, int right) {
        
        // System.out.println("In pivot search!");
        
        if(left > right) {
            // System.out.println("Detected left > right");
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        // System.out.println("Left is " + left + " value " + nums[left]);
        // System.out.println("Right is " + right + " value " + nums[right]);
        // System.out.println("Mid is " + mid + " value " + nums[mid]);
        
        if(nums[mid] == target) {
            return mid;
        }
        
        // Pivot on left
        if(nums[mid] < nums[left]) {
            
            // System.out.println("Detected pivot on left");
            
            // Value in normal RHS
            if(nums[mid] <= target && target <= nums[right]) {
                // System.out.println("Detected target in normal RHS");
                return normalSearch(nums, target, mid + 1, right);
            } else {
                // System.out.println("Detected target in pivoted LHS");
                return pivotSearch(nums, target, left, mid - 1);
            }
        // Pivot on right
        } else {
            
            // System.out.println("Detected pivot on right");
            
            // Value in normal LHS
            if(nums[left] <= target && target <= nums[mid]) {
                // System.out.println("Detected target in normal LHS");
                return normalSearch(nums, target, left, mid - 1);
            } else {
                // System.out.println("Detected target in pivoted RHS");
                return pivotSearch(nums, target, mid + 1, right);
            }
        }
        
    }
    
    private int normalSearch(int[] nums, int target, int left, int right) {
        
        if(left > right) {
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        
        if(nums[mid] == target) {
            return mid;
        } else if(target < nums[mid]) {
            return normalSearch(nums, target, left, mid - 1);
        } else {
            return normalSearch(nums, target, mid + 1, right);
        }
        
    }
}