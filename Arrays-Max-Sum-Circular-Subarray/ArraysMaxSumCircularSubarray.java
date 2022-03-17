class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int counter = 0;
        int pointer = 0;
        int counterStartIndex = pointer;
        
        boolean keepGoing = true;
        boolean foundNegative = false;
        boolean secondLoop = false;
                
        // [1, 2, 3]
        // [-1, -2, -3]
        // [-2, -1, -3]
        // [1, 2, 3, -4, 0, -5, 5]
        // [0, 0]
        while(keepGoing) {
            
            int num = nums[pointer];
            
            if(secondLoop && (num < 0 || pointer == counterStartIndex)) {
                keepGoing = false;
            } else if(num < 0 || (num > 0 && counter < 0)) {
                if(num < 0) {
                    foundNegative = true;
                }
                counter = num;
                counterStartIndex = pointer;
            } else {
                counter += num;
            }
            
            // System.out.println("Pointer " + pointer);
            // System.out.println("Counter " + counter);
            
            max = Math.max(max, counter);
            
            if(pointer == nums.length - 1 && foundNegative) {
                secondLoop = true;
                pointer = 0;
            } else if (pointer == nums.length - 1 && !foundNegative){
                keepGoing = false;
            } else {
                pointer++;
            }
        }
        
        return max;
    }
}