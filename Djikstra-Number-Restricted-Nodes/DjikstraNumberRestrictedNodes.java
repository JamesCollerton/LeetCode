class Solution {
    
    private class Node {
        int distance = Integer.MAX_VALUE;
        Map<Node, Integer> adjacencyList = new HashMap<>();
    }
    
    private int result = 0;
    private int n;
    private List<Node> graph = new ArrayList<>();
    
    public int countRestrictedPaths(int n, int[][] edges) {
        
        this.n = n;
                
        for(int i = 0; i < n; i++) {
            graph.add(new Node());
        }
        
        for(int i = 0; i < edges.length; i++) {
            int nodeA = edges[i][0] - 1;
            int nodeB = edges[i][1] - 1;
            int weight = edges[i][2];
            graph.get(nodeA).adjacencyList.put(graph.get(nodeB), weight);
            graph.get(nodeB).adjacencyList.put(graph.get(nodeA), weight);
        }
        
        Set<Node> seen = new HashSet<>();
        Queue<Node> queue = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        graph.get(graph.size() - 1).distance = 0;
        queue.add(graph.get(graph.size() - 1));
        
        while(!queue.isEmpty()) {
            
            Node currentNode = queue.poll();
            
            for(Map.Entry<Node, Integer> entry: currentNode.adjacencyList.entrySet()) {
                Node nextNode = entry.getKey();
                int distance = entry.getValue();
                
                if(!seen.contains(nextNode)) {
                    if(nextNode.distance > currentNode.distance + distance) {
                        nextNode.distance = currentNode.distance + distance;
                        queue.add(nextNode);
                    }
                }
            }
            
            seen.add(currentNode);
            
        }
        
        return dfs(graph.get(0), new HashSet<>());
    }
    
    private Map<Node, Integer> memoisation = new HashMap<>();
    
    private int dfs(Node node, HashSet<Node> seen) {
        if(memoisation.containsKey(node)) {
            return memoisation.get(node);
        }
        if(node == graph.get(n - 1)) {
            return 1;
        }
        
        seen.add(node);
        
        int result = 0;
        
        for(Node connectedNode: node.adjacencyList.keySet()) {
            if(!seen.contains(connectedNode) && node.distance > connectedNode.distance) {
                result = (result + dfs(connectedNode, new HashSet<>(seen))) % 1000000007;
            }
        }
        
        memoisation.put(node, result);
        
        return result;
    }
}