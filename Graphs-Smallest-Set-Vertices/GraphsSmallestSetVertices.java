class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        Set<Integer> startingNodes = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            startingNodes.add(i);
        }
        
        for(List<Integer> edge: edges) {
            startingNodes.remove(edge.get(1));
        }
        
        return new ArrayList<>(startingNodes);
    }
    
}