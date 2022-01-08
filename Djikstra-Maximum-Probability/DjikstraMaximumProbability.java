class Solution {
    
    private class Node implements Comparable<Node> {
        double distance = 0.0;
        Map<Node, Double> adjacencyList = new HashMap<>();
        
        @Override
        public int compareTo(Node that) {
            if(this.distance > that.distance) {
                return -1;
            }
            if(this.distance < that.distance) {
                return 1;
            }
            return 0;
        }
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        List<Node> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            graph.add(new Node());
        }
        
        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            double prob = succProb[i];
            graph.get(edge[0]).adjacencyList.put(graph.get(edge[1]), prob);
            graph.get(edge[1]).adjacencyList.put(graph.get(edge[0]), prob);
        }
        
        Set<Node> seen = new HashSet<>();
        
        // This goes by least element, so we want a first if the distance is greater,
        // but this must return a negative number
        Queue<Node> queue = new PriorityQueue<>();
        graph.get(start).distance = 1.0;
        queue.offer(graph.get(start));
        
        while(!queue.isEmpty()) {
            
            Node currentNode = queue.poll();
            seen.add(currentNode);
            
            for(Map.Entry<Node, Double> entry: currentNode.adjacencyList.entrySet()) {
                
                Node node = entry.getKey();
                double prob = entry.getValue();
                
                calculateMaxProb(node, prob, currentNode);
                
                if(!seen.contains(node)) {
                    queue.offer(node);
                }
            }
            
        }
        
        return graph.get(end).distance;
    }
    
    private void calculateMaxProb(Node node, double distance, Node previousNode) {
        
        double newDistance = distance * previousNode.distance;
        
        if(node.distance < newDistance) {
            node.distance = newDistance;
        }
        
    }
}