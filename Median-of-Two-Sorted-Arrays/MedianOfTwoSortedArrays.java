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
        
            return Double.valueOf(findNextValueWholeNumber(nums1, nums2, 0, 0, counter));    
        }
            
        // Decimal number case:
        int counter = (totalLength / 2) - 1;

        return findNextValueNotWholeNumber(nums1, nums2, 0, 0, counter);
    }
    
    private double findNextValueNotWholeNumber(int[] nums1, int[] nums2, int num1pos, int num2pos, int counter) {
             
        // Reached the end, select a number
        if(counter <= 0) {
            
            if(num1pos < nums1.length) {
                if(num2pos < nums2.length) {
                    
                    // If both arrays still have places to move then
                    // we need to find the next number in the series
                    // and take the average between the two.
                    
                    if(nums1[num1pos] < nums2[num2pos]) {
                        
                        // We are currently in the number one array, if the
                        // next item in the number two array is smaller than
                        // the next item in the number one array then we take
                        // the average of those two, otherwise use both number
                        // one arrays
                        
                        if((num1pos + 1) < nums1.length) {
                            if(nums1[num1pos + 1] < nums2[num2pos]) {
                                return (nums1[num1pos] + nums1[num1pos + 1]) / 2.0;
                            } else {
                                return (nums1[num1pos] + nums2[num2pos]) / 2.0;
                            }
                        }                        
                        return (nums1[num1pos] + nums2[num2pos]) / 2.0;
                    } else {
                        
                        // We are currently in the number two array, if the
                        // next item in the number two array is smaller than
                        // the next item in the number one array then we take
                        // the average of those two, otherwise use both number
                        // one arrays
                        if((num2pos + 1) < nums2.length) {
                            if(nums2[num2pos + 1] < nums1[num1pos]) {
                                return (nums2[num2pos] + nums2[num2pos + 1]) / 2.0;
                            } else {
                                return (nums1[num1pos] + nums2[num2pos]) / 2.0;
                            }
                        } 
                                                
                        return (nums1[num1pos] + nums2[num2pos]) / 2.0;
                        
                    }
                } else {
                    
                    // If the position of number two is outside the length, then we've exhausted
                    // the second vector and we must be on the first one
                    
                    return (nums1[num1pos] + nums1[num1pos + 1]) / 2.0;
                }
            } else {
                            
                // If the position of number one is outside the length, then we've exhausted
                // the first vector and we must be on the second one
                return (nums2[num2pos] + nums2[num2pos + 1]) / 2.0;
            }
        }
        
        if(num1pos < nums1.length) {
            if(num2pos < nums2.length) {
                if(nums1[num1pos] < nums2[num2pos]) {
                    System.out.println("A");
                    int newNum1Pos = Math.min(num1pos + 1, nums1.length - 1);
                    return findNextValueNotWholeNumber(nums1, nums2, num1pos + 1, num2pos, counter - 1);
                }
                System.out.println("B");
                int newNum2Pos = Math.min(num2pos + 1, nums2.length - 1);
                return findNextValueNotWholeNumber(nums1, nums2, num1pos, num2pos + 1, counter - 1);
            } else {
                System.out.println("C");
                int newNum1Pos = Math.min(num1pos + 1, nums1.length - 1);
                return findNextValueNotWholeNumber(nums1, nums2, num1pos + 1, num2pos, counter - 1);
            }
        } else {
            System.out.println("D");
            int newNum2Pos = Math.min(num2pos + 1, nums2.length - 1);
            return findNextValueNotWholeNumber(nums1, nums2, num1pos, num2pos + 1, counter - 1);
        }
        
    }
    
    private int findNextValueWholeNumber(int[] nums1, int[] nums2, int num1pos, int num2pos, int counter) {
        
        // Reached the end, select a number
        if(counter <= 0) {
            
            if(num1pos < nums1.length) {
                if(num2pos < nums2.length) {
                    
                    // If both arrays still have places to move then
                    // we can just choose the place in the series we 
                    // are at
                    
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
                    return findNextValueWholeNumber(nums1, nums2, num1pos + 1, num2pos, counter - 1);
                }
                return findNextValueWholeNumber(nums1, nums2, num1pos, num2pos + 1, counter - 1);
                
            } else {
                return findNextValueWholeNumber(nums1, nums2, num1pos + 1, num2pos, counter - 1);
            }
        } else {
            return findNextValueWholeNumber(nums1, nums2, num1pos, num2pos + 1, counter - 1);
        }
        
    }
}