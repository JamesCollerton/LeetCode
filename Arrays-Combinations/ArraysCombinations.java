class Solution {
    
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        if(k == 0) {
            return result;
        }
        
        for(int i = 1; i <= n; i++) {
            List<Integer> list = new LinkedList<>();
            list.add(i);
            backtrack(i, list, k, n);
        }
        
        return result;
    }
    
    private void backtrack(int curr, List<Integer> list, int k, int n) {
        if(list.size() == k) {
            result.add(new LinkedList<>(list));
            return;
        }
        
        for(int i = curr + 1; i <= n; i++) {
            list.add(i);
            backtrack(i, list, k, n);
            list.remove(list.size() - 1);
        }
    }
}