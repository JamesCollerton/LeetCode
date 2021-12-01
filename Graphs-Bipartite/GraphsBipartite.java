class Solution {
    
    private int[] sets;
    private final int A = -1;
    private final int B = 1;
    private final int NO_SET = 0;
    
    public boolean isBipartite(int[][] graph) {
        
        sets = new int[graph.length];
        
        for(int node = 0; node < graph.length; node++) {
            if(sets[node] == NO_SET) {
                if(!createAndCheckValidSets(graph, node, A)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean createAndCheckValidSets(int[][] graph, int node, int currentSet) {
        
        sets[node] = currentSet;
        
        for(int i = 0; i < graph[node].length; i++) {
            int adjacentNode = graph[node][i];
            if(sets[adjacentNode] == currentSet) {
                return false;
            } else if(sets[adjacentNode] == NO_SET) {
                int nextSet = currentSet == A ? B : A;
                if(!createAndCheckValidSets(graph, adjacentNode, nextSet)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}