class Solution {
        
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return kSum(nums, target, 4);  
    }
    
    private List<List<Integer>> kSum(int[] nums, int target, int k) {
        
        // Sort the list O(log(n))
        
        // We want to be k apart so [0], [0 + 1], [0 + 2], ... [0 + k]
            
        // We can have a recursive step, just by chopping off the first of the array         
        
        // Once we get over k we can finish, as the list is sorted we know the numbers 
        // only get higher.
        
        // Make sure we check the list hasn't ended.
        
        Arrays.sort(nums);
        return kSumStep(nums, target, k);
    }
    
    private List<List<Integer>> kSumStep(int[] nums, int target, int k) {
        int sum = 0;
        List<Integer> newSolutions = new ArrayList<Integer>();
        for(int i = 0; i < k; i++) {
            if(i < nums.length) {
                sum += nums[i];
                newSolutions.add(nums[i]);
            } else {
                // Past the end of the array, we're done.                 
                return new ArrayList<List<Integer>>();
            }
        }
        
        if(sum > target) {
            // We can stop now, as the array is sorted the total will only
            // get higher
            return new ArrayList<List<Integer>>();
        }
        
        if(sum == target) {
            List<List<Integer>> arrayList = kSumStep(Arrays.copyOfRange(nums, 1, nums.length), target, k);
            arrayList.add(newSolutions);
            return arrayList;
        } else {
            List<List<Integer>> arrayList = kSumStep(Arrays.copyOfRange(nums, 1, nums.length), target, k);
            return arrayList;
        }
    }
}