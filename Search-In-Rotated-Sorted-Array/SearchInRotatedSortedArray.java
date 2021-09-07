class Solution {
    public int search(int[] nums, int target) {
        // The array is already sorted, search it normally
        if(nums[0] < nums[nums.length - 1]) {
            System.out.println("Detected normal search straight away");
            return normalSearch(nums, target, 0, (nums.length - 1));
            
            
        // The array is not sorted, do the pivot search
        } else {
            System.out.println("Detected pivot search straight away");
            return pivotSearch(nums, target, 0, (nums.length - 1));
            
        }
    }
    
    private int pivotSearch(int[] nums, int target, int startPointer, int endPointer) {
                
        // If we've gone through the entire array
        if(startPointer > endPointer) {
            System.out.println("Gone through entire array in pivot search");
            return -1;
            
        // If we're at the end of the search and we found the target, return the index
        }
        else if(startPointer == endPointer && nums[startPointer] == target) {
            
            System.out.println("Found value in pivot search");
            return startPointer;
            
        // If we're at the end of the search and the target isn't found, return -1
        } else if(startPointer == endPointer) {
            
            System.out.println("At the end of search in pivot search");
            return -1;
        }
        
        if(nums[startPointer] == target) {
            return startPointer;
        }
        if(nums[endPointer] == target) {
            return endPointer;
        }
        if(nums.length == 2) {
            return -1;
        }
        
        // Find the middle of the array
        int middle = (startPointer + endPointer) / 2;
        System.out.println("Middle is " + middle + " in pivot search");
        
        // Check to see if the middle is the solution
        if(nums[middle] == target) {
            System.out.println("Found target as middle " + middle + " in pivot search");
            return middle;
        }
        
        // The LHS of the array is sorted
        if(nums[startPointer] < nums[middle]) {
                        
            System.out.println("The LHS of the array is sorted in pivot search");
            
            // The value if exists is in the sorted LHS
            if(nums[startPointer] <= target && target < nums[middle]) {
                System.out.println("The target is in the sorted LHS in pivot search");
                
                return normalSearch(nums, target, startPointer, middle - 1);
                
            // The value if exists is in the not sorted RHS
            } else {
                System.out.println("The target is in the unsorted RHS in pivot search");
                
                return pivotSearch(nums, target, middle + 1, endPointer);
            }
            
        // The RHS of the array is sorted
        } else {
            
            System.out.println("The RHS of the array is sorted in pivot search");
            System.out.println("Endpointer " + endPointer);
            
            // The value if exists is in the sorted RHS
            if(nums[middle] < target && target <= nums[endPointer]) {
                System.out.println("The target is in the sorted RHS in pivot search");
                
                return normalSearch(nums, target, middle + 1, endPointer);
                
            // The value if exists is in the not sorted LHS
            } else {
                System.out.println("The target is in the unsorted LHS in pivot search");
                
                return pivotSearch(nums, target, startPointer, middle - 1);
            }
            
        }
    }
    
    // This is the search when we know it's sorted
    private int normalSearch(int[] nums, int target, int startPointer, int endPointer) {
                
        // If we've gone through the entire array
        if(startPointer > endPointer) {
            return -1;
            
        // If we're at the end of the search and we found the target, return the index
        }
        if(startPointer == endPointer && nums[startPointer] == target) {
            return startPointer;
            
        // If we're at the end of the search and the target isn't found, return -1
        } else if(startPointer == endPointer) {
            return -1;
        }
        
        if(nums[startPointer] == target) {
            return startPointer;
        }
        if(nums[endPointer] == target) {
            return endPointer;
        }
        if(nums.length == 2) {
            return -1;
        }
        
        // Find the middle of the array
        int middle = (startPointer + endPointer) / 2;
        if(nums[middle] == target) {
            return middle;
        }
        
        // The number is on the LHS
        if(target < nums[middle]) {
            return normalSearch(nums, target, startPointer, middle - 1);
            
        // The number is on the RHS
        } else {
            return normalSearch(nums, target, middle + 1, endPointer);
        }
    }
}