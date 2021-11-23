class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
     
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            
            int currentNumber = nums[i];
            int currentMax = 0;
            
            if(!set.contains(currentNumber - 1)) {
                
                while(set.contains(currentNumber++)) {
                    currentMax++;
                }
                
                max = Math.max(currentMax, max);
            }
        }
        return max;
    }
    
}