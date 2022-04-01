class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        Set<Integer> result = new HashSet<>();
        
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new LinkedList<>());
        }
        
        for(List<Integer> edge: edges) {
            adjacencyList.get(edge.get(0)).add(edge.get(1));
        }
        
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                result.add(i);
                dfs(visited, adjacencyList, i, result);
            }
        }
        
        return new LinkedList<>(result);
    }
    
    private void dfs(boolean[] visited, List<List<Integer>> adjacencyList, int node, Set<Integer> result) {
        
        visited[node] = true;
        
        for(int connectedNode: adjacencyList.get(node)) {
            if(result.contains(connectedNode)) {
                result.remove(connectedNode);
            }
            if(!visited[connectedNode]) {
                dfs(visited, adjacencyList, connectedNode, result);
            }
        }
        
    }
}