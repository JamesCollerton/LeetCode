class Solution {
    
    private int n;
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        n = graph.length;
        
        findAllPaths(graph, 0, new ArrayList<>());
        
        return result;
    }
    
    private void findAllPaths(int[][] graph, int currentNode, List<Integer> currentPath) {
        
        currentPath.add(currentNode);
        
        if(currentNode == n - 1) {
            result.add(currentPath);
            return;
        }
        
        for(int nextNode = 0; nextNode < graph[currentNode].length; nextNode++) {
            findAllPaths(graph, graph[currentNode][nextNode], new ArrayList<>(currentPath));
        }
    }
}