class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
                
        List<List<Integer>> result = new ArrayList<>();
        
        if(nums.length < 3) {
            return new ArrayList<>();
        }
        
        Arrays.sort(nums);
        
        for(int p1 = 0; p1 < nums.length - 2; p1++) {
            if (p1 == 0 || (p1 > 0 && nums[p1] != nums[p1 - 1])) {
                int p2 = p1 + 1;
                int p3 = nums.length - 1;
                int target = -nums[p1];
            
                while(p2 < p3) {
                    if(nums[p2] + nums[p3] == target) {
                        result.add(List.of(nums[p1], nums[p2], nums[p3]));
                        while(p2 < p3 && nums[p2] == nums[p2 + 1]) {
                            p2++;    
                        }
                        while(p2 < p3 && nums[p3] == nums[p3 - 1]) {
                            p3--;
                        }
                        p2++;
                        p3--;
                    } else if(nums[p2] + nums[p3] < target) {
                        p2++;
                    } else {
                        p3--;
                    }
                }
            }
        }
        
        return result;
    }
}