class Solution {
    
    private int numberDistinctGroups = 0;
    private int numberSpareCables = 0;
    
    public int makeConnected(int n, int[][] connections) {
        
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < connections.length; i++) {
            adjacencyList.get(connections[i][0]).add(connections[i][1]);
            adjacencyList.get(connections[i][1]).add(connections[i][0]);
        }
        
        Set<Integer> seenNodes = new HashSet<>();
        
        for(int node = 0; node < n; node++) {
            if(!seenNodes.contains(node)) {
                countDistinctGroupsAndSpareCables(adjacencyList, node, seenNodes);
                System.out.println(node);
                numberDistinctGroups++;
            }            
        }
        
        return numberSpareCables >= numberDistinctGroups - 1 ? numberDistinctGroups - 1 : -1;
    }
    
    private void countDistinctGroupsAndSpareCables(
        List<List<Integer>> adjacencyList, 
        int node, 
        Set<Integer> seenNodes
    ) {
        
        seenNodes.add(node);
        
        for(int nextNodeIndex = 0; nextNodeIndex < adjacencyList.get(node).size(); nextNodeIndex++) {
            int nextNode = adjacencyList.get(node).get(nextNodeIndex);
            
            if(seenNodes.contains(nextNode)) {
                numberSpareCables++;
            } else {
                countDistinctGroupsAndSpareCables(adjacencyList, nextNode, seenNodes);
            }
        }
        
    }
}