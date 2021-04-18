class Solution {
        
    public List<List<Integer>> fourSum(int[] nums, int target) {

        HashSet<List<Integer>> result = new HashSet<List<Integer>>();
        
        for(int a = 0; a < nums.length; a++) {
            for(int b = 0; b < nums.length; b++) {
                for(int c = 0; c < nums.length; c++) {
                    for(int d = 0; d < nums.length; d++) {
                        if(Stream.of(a, b, c, d).distinct().count() == 4 &&
                            nums[a] + nums[b] + nums[c] + nums[d] == target) {
                            List<Integer> list = Arrays.asList(nums[a], nums[b], nums[c], nums[d]);
                            Collections.sort(list);
                            result.add(list);
                        }
                    }
                }
            }
        }
        
        return new ArrayList<List<Integer>>(result);
    }
}