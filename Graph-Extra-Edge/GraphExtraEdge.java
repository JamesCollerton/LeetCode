class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int numberNodes = edges.length;
        
        System.out.println("Number of nodes " + numberNodes);
        
        List<List<Integer>> adjacencyList = initialiseGraph(edges, numberNodes);
        
        for(List<Integer> list: adjacencyList) {
            System.out.println(list);
        }

        for(int i = 0; i < edges.length; i++) {
            int currentIndex = edges.length - 1 - i;
            int[] edge = edges[currentIndex];
            
            int source = edge[0];
            int dest = edge[1];
            
            if(canFindRoute(adjacencyList, source, dest)) {
                return edge;
            }
        }
        
        return new int[0];
    }
    
    private boolean canFindRoute(List<List<Integer>> adjacencyList, int source, int dest) {        
        return dfs(source, -1, adjacencyList, source, dest, new HashSet<>());
    }
    
    private boolean dfs(
        int currentNode, 
        int lastNode,
        List<List<Integer>> adjacencyList,
        int start,
        int target, 
        HashSet<Integer> seen
    ) {
        
        if(seen.contains(currentNode)) {
            return false;
        }
        
        if(currentNode == target && lastNode != start) {
            return true;
        }
        
        seen.add(currentNode);
        
        boolean solution = false;
        for(int nextNode: adjacencyList.get(currentNode)) {
            solution = solution || dfs(nextNode, currentNode, adjacencyList, start, target, seen);
        }
        
        return solution;
    }
    
    private List<List<Integer>> initialiseGraph(int[][] edges, int numberNodes) {
        List<List<Integer>> adjacencyList = new ArrayList<List<Integer>>();   
        
        for(int i = 0; i <= numberNodes; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
        
        for(int[] edge: edges) {
            int source = edge[0];
            int dest = edge[1];            
            adjacencyList.get(source).add(dest);
            adjacencyList.get(dest).add(source);
        }
        
        return adjacencyList;
    }
}