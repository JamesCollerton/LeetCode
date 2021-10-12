class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // Create a new list, which is our results
        List<List<Integer>> list = new ArrayList<>();
        // Sort array as we sometimes use this for early cut off
        Arrays.sort(nums);
        // Call recursion
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        // We're going backwards and decreasing the total, if the total is below zero
        // we can just ignore it
        if(remain < 0) {
            return;
        }
        // If the total we're going up against is zero then we've got a solution, add
        // it to the set!
        else if(remain == 0) {
            list.add(new ArrayList<>(tempList));
        } else{ 
            // For all of the remaining numbers we want to look at
            // add them to the list and recurse down
            for(int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i);
                // This is to pop items back off the tree as this is essentially
                // a DFS. By the time we've got back up to this point we will be
                // back at the tree state we were originally
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}