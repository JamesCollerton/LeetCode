class Solution {
    
    private Set<Integer> safe = new HashSet<>();
    private Set<Integer> seen = new HashSet<>();
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        for(int node = 0; node < graph.length; node++) {
            if(!seen.contains(node)) {
                findSafeNodes(graph, node, new HashSet<>());
            }
        }
        
        // Check this sorts in right order and exists
        
        List<Integer> result = new ArrayList<>(safe);
        Collections.sort(result);
        return result;
    }
    
    private boolean findSafeNodes(int[][] graph, int node, Set<Integer> seen) {
        
        seen.add(node);
        
        // Terminal node
        if(graph[node].length == 0) {
            safe.add(node);
            return true;
        }
        
        for(int i = 0; i < graph[node].length; i++) {
            int nextNode = graph[node][i];
            if(!safe.contains(nextNode)) {
                if(seen.contains(nextNode) || !findSafeNodes(graph, nextNode, new HashSet<>(seen))) {
                    return false;
                }
            }
        }
        
        safe.add(node);
        return true;
    }
}