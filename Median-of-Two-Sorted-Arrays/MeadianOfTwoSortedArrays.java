class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        // Find total length of two arrays
        int totalLength = nums1.length + nums2.length;
        
        // Find middle number, two cases, it's a whole number, it's a decimal
        // If we have an odd number of entries then it is a whole number case.
        boolean isWholeNumberCase = (totalLength % 2 == 1);
        
        // Whole number case:
        if(isWholeNumberCase){
        
            // Declare Counter
            int counter = totalLength / 2;
        
            // Find which of the two arrays has smallest first element, start there
            // int start;
            // if(nums1.length != 0 && (nums2.length == 0 || nums1[0] <= nums2[0])) {
            return Double.valueOf(findNextValue(nums1, nums2, 0, 0, counter));
            // } else {
            //     return Double.valueOf(findNextValue(nums1, nums2, 0, 1, counter - 1));
            // }
    
        }
            
        // Decimal number case:
        
            // Declare Counter
        
            // Find which of the two arrays has smallest first element, start there
        
            // Check to see which of the two arrays has the next smallest element, go there, increase counter
        
            // Take the step again, when we reach the bottom number of the two middle numbers find the next
            // element and take the average.
        return 0.0;
    }
    
    private int findNextValue(int[] nums1, int[] nums2, int num1pos, int num2pos, int counter) {
        
        System.out.println(counter);
        
        // Reached the end, select a number
        if(counter <= 0) {
            
            if(num1pos < nums1.length) {
                if(num2pos < nums2.length) {
                    
                    // If both arrays still have places to move then
                    // we can just choose the next in the series
                    
                    if(nums1[num1pos] < nums2[num2pos]) {
                        return nums1[num1pos];
                    } else {
                        return nums2[num2pos];
                    }
                } else {
                    
                    // If the position of number two is outside the length, then we've exhausted
                    // the second vector and we must be on the first one
                    
                    return nums1[num1pos];
                }
            } else {
                            
                // If the position of number one is outside the length, then we've exhausted
                // the first vector and we must be on the second one
                return nums2[num2pos];
            }
        }
        
        // Check to see which of the two arrays has the next smallest element, go there, increase counter
        // Take the step again, return the value once the counter reaches the middle number
        
        if(num1pos < nums1.length) {
            if(num2pos < nums2.length) {
                
                if(nums1[num1pos] < nums2[num2pos]) {
                    return findNextValue(nums1, nums2, num1pos + 1, num2pos, counter - 1);
                }
                return findNextValue(nums1, nums2, num1pos, num2pos + 1, counter - 1);
                
            } else {
                return findNextValue(nums1, nums2, num1pos + 1, num2pos, counter - 1);
            }
        } else {
            return findNextValue(nums1, nums2, num1pos, num2pos + 1, counter - 1);
        }
        
    }
}