class Solution {
        
    private class Node {
        int distance = Integer.MAX_VALUE;
        Map<Node, Integer> adjacencyList = new HashMap<>();
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {

        List<Node> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            graph.add(new Node());
        }
        
        for(int i = 0; i < times.length; i++) {
            int from = times[i][0];
            int to = times[i][1];
            int distance = times[i][2];
            graph.get(from - 1).adjacencyList.put(graph.get(to - 1), distance);
        }
        
        Set<Node> seen = new HashSet<>();
        Queue<Node> queue = new PriorityQueue<>((a, b) -> (a.distance - b.distance));
        
        graph.get(k - 1).distance = 0;
        queue.offer(graph.get(k - 1));
        
        while(!queue.isEmpty()) {
            
            Node currentNode = queue.poll();
            seen.add(currentNode);
            
            for(Map.Entry<Node, Integer> entry : currentNode.adjacencyList.entrySet()) {
                Node node = entry.getKey();
                int distance = entry.getValue();
                
                int newDistance = distance + currentNode.distance;
                if(newDistance < node.distance) {
                    node.distance = newDistance;
                }
                
                if(!seen.contains(node)) {
                    queue.offer(node);
                }
            }
            
        }
        
        int result = -1;
        
        for(Node node: graph) {
            if(node.distance == Integer.MAX_VALUE) {
                return -1;
            }
            result = Math.max(result, node.distance);
        }
        
        return result;
    }
    
}