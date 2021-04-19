class Solution {
        
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);  
    }
    
    private List<List<Integer>> kSum(int[] nums, int target, int start, int k) { 
        List<List<Integer>> res = new ArrayList<>();
        
        if(start == nums.length) {
            // We're at the end of the array, stop.
            return res;
        } else if(nums[start] * k > target) {
            // The array is sorted, we can't get equal to target
            return res;
        } else if(target > nums[nums.length - 1] * k) {
            // The target is too big, we can't do it
        }
        
        // We have two pointers and we want to return any pair between the start and the
        // end that matches the target
        if (k == 2){
            return twoSum(nums, target, start);
        }
        
        // Now move the current pointer from the start to the end of the array         
        for (int i = start; i < nums.length; ++i) {
            
            // If the last pointer is the same as this pointer then don't bother as
            // we'll end up with a repeated solution.             
            if (i == start || nums[i - 1] != nums[i]){
            
                // Each time we want to decrease the target and the number of pointers we can
                // use, as well as increment the start point             
                for (var set : kSum(nums, target - nums[i], i + 1, k - 1)) {

                    // We only enter this loop if we have a solution, in which case we want to 
                    // add our current number to the solution, then add all of the other ones
                    // on top of it.                 
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(set);
                }
                
            }
        }
        
        return res;
        
    }
    
    // This finds us a pair of numbers that add up to a target by 
    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            // Second part is if our current number is the same as the last one
            // to stop us getting a repeat solution             
            if (sum < target || (lo > start && nums[lo] == nums[lo - 1]))
                ++lo;
            else if (sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1]))
                --hi;
            else
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
        }
        return res;
    }
    
}