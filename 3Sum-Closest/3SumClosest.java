class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        // Make initial result with first three elements
        int[] result = new int[]{ nums[0], nums[1], nums[2] };
        
        // Go through all next elements to see if we should
        // swap them out
        for(int i = 3; i < nums.length; i++) {
            
            // Get the element in the list at i
            int value = nums[i];
            
            // Sum up what we currently have in the result
            // See if we can optimise this slightly
            int currentResultSum = 0;
            for(int j = 0; j < result.length; j++) {
                currentResultSum += result[j];    
            }
            
            // Find the distance we are trying to decrease
            int currentDistance = abs(target - currentResultSum);
            
            // If we can replace one of the existing numbers
            // with the value, then we will set this to the
            // index of the number to replace
            int swapIndex = -1;
            
            // This is the distance to beat!
            int minNewDistance = -1;
            
            // Go through each of the result entries and see
            // what happens if we swap them out
            for(int k = 0; k < result.length; k++) {
                
                // Find the sum of the results if we replace
                // the kth value with the new item in the 
                // list
                int newResultSum = 0;
                for(int l = 0; l < result.length; l++) {
                    if(l == k) {
                        newResultSum += value;
                    } else {
                        newResultSum += result[l];
                    }
                }
                
                // Find the new distance
                int newDistance = abs(target - newResultSum);
                
                // If the new distance is less than the current one
                // and the minimum distance we can make by swapping
                // out any of the items we're good
                if(newDistance < currentDistance) {
                    if(minNewDistance == -1 || 
                        (minNewDistance != - 1 && newDistance < minNewDistance)) {
                        minNewDistance = newDistance;
                        swapIndex = k;
                    }
                }
            }
            
            // Swap it out
            if(swapIndex != -1) {
               result[swapIndex] = value; 
            }
        }
        
        // Sum up results and return results
        int resultSum = 0;
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
            resultSum += result[i];    
        }
        return resultSum;
    }
    
    private int abs(int value) {
        return value < 0 ? -value : value;
    }
}