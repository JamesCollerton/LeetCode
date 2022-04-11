class Solution {
        
    // [0,1]
    // [1,1]
    // [1,2]
    // [0,2]
    // n = 5
    public int makeConnected(int n, int[][] connections) {
        
        if(connections.length < n - 1) {
            return -1;
        }
        
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new LinkedList<>());
        }
        
        // 0 -> 1, 2
        // 1 -> 0, 1, 2
        // 2 -> 0, 1
        // 3
        // 4
        for(int[] connection: connections) {
            adjacencyList.get(connection[0]).add(connection[1]);
            adjacencyList.get(connection[1]).add(connection[0]);
        }
        
        Set<Integer> seen = new HashSet<>();
        
        int numberGroups = 0;
        
        for(int i = 0; i < n; i++) {
            if(!seen.contains(i)) {
                numberGroups++;
                dfs(i, adjacencyList, seen);
            }
        }
        
        return numberGroups - 1;
    }

    // Spare cables: 1, 2
    // Seen: 0, 1, 2
    
    // 0 -> 1, 2
    // 1 -> 1, 2
    // 2 -> 0, 1
    // 3
    // 4
    private void dfs(int node, List<List<Integer>> adjacencyList, Set<Integer> seen) {
        
        seen.add(node);
        
        for(int connectedNode: new HashSet<>(adjacencyList.get(node))) {
            if(!seen.contains(connectedNode)) {
                dfs(connectedNode, adjacencyList, seen);
            }
        }
        
    }
    
}