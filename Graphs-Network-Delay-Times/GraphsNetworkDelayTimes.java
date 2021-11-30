class Solution {
        
    private class Edge {
        int weight;
        int destination;
        Edge(int weight, int destination) {
            this.weight = weight;
            this.destination = destination;
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<List<Edge>> adjacencyList = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < times.length; i++) {
            int source = times[i][0];
            int destination = times[i][1];
            int weight = times[i][2];
            
            adjacencyList.get(source).add(new Edge(weight, destination));
        }
        
        Map<Integer, Integer> timeToReachNode = new HashMap<>();
        
        findMaxTime(adjacencyList, k, timeToReachNode, 0);
        
        if(timeToReachNode.size() != n) {
            return -1;
        }
        
        return Collections.max(timeToReachNode.values());
    }
    
    private void findMaxTime(
        List<List<Edge>> adjacencyList,  
        int currentNode, 
        Map<Integer, Integer> timeToReachNode,
        int timeElapsed
    ) {
        
        if(timeToReachNode.containsKey(currentNode) && timeElapsed >= timeToReachNode.get(currentNode)) {
            return;
        }
        
        timeToReachNode.put(currentNode, timeElapsed);
        
        for(Edge edge: adjacencyList.get(currentNode)) {
            findMaxTime(adjacencyList, edge.destination, timeToReachNode, timeElapsed + edge.weight);
        }
    }
}