class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        
        Set<Integer> roots = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            roots.add(i);
        }
        
        for(int i = 0; i < leftChild.length; i++) {
            roots.remove(leftChild[i]);
        }
        for(int i = 0; i < rightChild.length; i++) {
            roots.remove(rightChild[i]);
        }
        
        if(roots.size() != 1) {
            return false;
        }
        
        int root = roots.stream().findFirst().get();
        
        Set<Integer> seen = new HashSet<>();
        
        if(!dfs(root, leftChild, rightChild, seen) || seen.size() != n) {
            return false;
        }
        
        return true;
    }
    
    private boolean dfs(int pos, int[] leftChild, int[] rightChild, Set<Integer> seen) {
        if(seen.contains(pos)) {
            return false;
        }
        
        seen.add(pos);
        
        boolean isValid = true;
        if(leftChild[pos] != -1) {
            isValid = isValid && dfs(leftChild[pos], leftChild, rightChild, seen);
        }
        if(isValid && rightChild[pos] != -1) {
            isValid = isValid && dfs(rightChild[pos], leftChild, rightChild, seen);
        }
        
        return isValid;
    }
}