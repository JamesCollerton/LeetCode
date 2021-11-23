class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int threshold = nums.length / 3;
        
        for(int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            
            if(map.containsKey(currentNumber)) {
                map.put(currentNumber, map.get(currentNumber) + 1);
            } else {
                map.put(currentNumber, 1);
            }
            
            if(map.get(currentNumber) > threshold) {
                set.add(currentNumber);
            }
        }
        
        return new ArrayList<>(set);
    }
}