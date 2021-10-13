class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), candidates, 0, target);
        return result;
    }
    
    private void backtrack(
        List<List<Integer>> result, 
        List<Integer> tempList, 
        int[] candidates, 
        int start, 
        int remainder
    ) {
        
        if(remainder < 0) {
            return;
        } else if(remainder == 0) {
            result.add(new ArrayList<Integer>(tempList));
        } else {
            for(int i = start; i < candidates.length; i++) {
                if(!(i > start && candidates[i] == candidates[i - 1])) {
                    tempList.add(candidates[i]);
                    backtrack(result, tempList, candidates, i + 1, remainder - candidates[i]);
                    tempList.remove(tempList.size() - 1);     
                }
            }
        }
        
    }
}