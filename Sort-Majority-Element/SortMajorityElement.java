class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for(int num: nums) {
            numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
            if(numsMap.get(num) > nums.length / 2) {
                return num;
            }
        }
        return 0;
    }
}