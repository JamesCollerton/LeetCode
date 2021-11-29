class Solution {
    public int findMaxLength(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int counter = 0;
        
        int max = 0;
        
        // We use -1 as this is the same as saying the sum
        // is zero before we even start.
        map.put(0, -1);
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                counter--;
            } else {
                counter++;
            }
            
            if(map.containsKey(counter)) {
                max = Math.max(max, i - map.get(counter));
            } else {
                map.put(counter, i);
            }
        }
        
        
        return max;
    }
}