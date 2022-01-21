class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Set<List<Integer>> result = new HashSet<>();
        
        if(nums.length < 3) {
            return new ArrayList<>();
        }
        
        Arrays.sort(nums);
        
        for(int p1 = 0; p1 < nums.length - 2; p1++) {
            int p2 = p1 + 1;
            int p3 = nums.length - 1;
            
            while(p2 < p3) {
                if(nums[p1] + nums[p2] + nums[p3] == 0) {
                    result.add(List.of(nums[p1], nums[p2], nums[p3]));
                    p2++;
                    p3--;
                } else if(nums[p1] + nums[p2] + nums[p3] < 0) {
                    p2++;
                } else {
                    p3--;
                }
            }
        }
        
        return new ArrayList<>(result);
    }
}