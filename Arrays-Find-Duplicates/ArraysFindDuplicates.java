class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        
        // As we know that the number in the array is going
        // to be less than the length of the array itself we
        // can flip the number at that index.
        for(int i = 0; i < nums.length; i++) {
            
            // Get the index corresponding to the number we've
            // retrieved from the array. We need to minus one as
            // the array values run from 1 to the max size.
            int indexLookingAt = Math.abs(nums[i]) - 1;
            
            // If we've already seen it, flip it.
            if(nums[indexLookingAt] < 0) {
                result.add(Math.abs(indexLookingAt + 1));
            }
            
            // We can do this as we know items will only turn up
            // once or twice.
            nums[indexLookingAt] = -nums[indexLookingAt];
        }
        
        return result;
    }
}