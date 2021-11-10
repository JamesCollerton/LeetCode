class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> remainderToIndexMap = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if(remainderToIndexMap.containsKey(remainder)) {
                return new int[]{ i, remainderToIndexMap.get(remainder) };
            } else {
                remainderToIndexMap.put(nums[i], i);
            }
        }
        
        return null;
    }
}