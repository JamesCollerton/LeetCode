class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        
        dfs(nums, new boolean[nums.length], new LinkedList<>());
        
        return result;
    }
    
    private void dfs(int[] nums, boolean[] seen, List<Integer> path) {
        if(path.size() == seen.length) {
            result.add(path);
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!seen[i]) {
                path.add(nums[i]);
                seen[i] = true;
                dfs(nums, seen, new LinkedList<>(path));
                path.remove(path.size() - 1);
                seen[i] = false;
            }
        }
        
    }
}