class Solution {
    public int[] findRedundantConnection(int[][] edges) {
       
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        for(int i = 0; i < edges.length + 1; i++) {
            adjacencyList.add(new LinkedList<>());
        }
        
        for(int[] edge: edges) {
            if(canFindTarget(new ArrayList<>(adjacencyList), edge[0], edge[1], new HashSet<>())) {
                return edge;
            }
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        
        return new int[0];
    }
    
    private boolean canFindTarget(List<List<Integer>> adjacencyList, int current, int target, Set<Integer> seen) {
        
        if(current == target) {
            return true;
        }
        
        seen.add(current);
        
        boolean result = false;
        
        for(int connected: adjacencyList.get(current)) {
            if(!seen.contains(connected)) {
                result = result || canFindTarget(adjacencyList, connected, target, seen);
            }
        }
        
        return result;
    }
}