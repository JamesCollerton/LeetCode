class Solution {
    
    private class Graph {
        List<Node> nodes = new ArrayList<>();
    }
    
    private class Node {
        Integer number;
        int distance = Integer.MAX_VALUE;
        Map<Node, Integer> adjacencyList = new HashMap<>();
        List<Node> path = new LinkedList<>();
        
        Node(int number) {
            this.number = number;
        }
        
        @Override
        public String toString() {
            return "Node: " + number + "\n" +
                    "Distance: " + distance + "\n" +
                    "Path: " + path.stream().map(n -> n.number.toString()).collect(Collectors.joining("-"));

        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Graph graph = new Graph();
        
        for(int i = 0; i < n; i++) {
            graph.nodes.add(new Node(i));
        }
        
        for(int[] flight: flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph.nodes.get(from).adjacencyList.put(graph.nodes.get(to), price);
        }
        
        // for(Node node: graph.nodes) {
        //     System.out.println(node);
        // }
        
        Set<Node> seen = new HashSet<>();
        Queue<Node> queue = new PriorityQueue<>((a, b) -> b.distance - a.distance);
        
        Node source = graph.nodes.get(src);
        
        source.distance = 0;
        queue.add(source);
        
        while(!queue.isEmpty()) {
            
            Node currentNode = queue.remove();
            
            if(!seen.contains(currentNode) && currentNode.path.size() <= k) {
                
                for(Map.Entry<Node, Integer> entry: currentNode.adjacencyList.entrySet()) {
                    
                    Node node = entry.getKey();
                    int distance = entry.getValue();
                    
                    calculateMinimumDistance(node, distance, currentNode);
                    
                    seen.add(currentNode);
                    queue.add(node);
                }
                
            }
            
        }
        
        for(Node node: graph.nodes) {
            System.out.println(node);
        }
        
        return graph.nodes.get(dst).distance == Integer.MAX_VALUE ? -1 : graph.nodes.get(dst).distance;
    }
    
    private void calculateMinimumDistance(Node node, int distance, Node currentNode) {
        
        int newDistance = distance + currentNode.distance;
        
        if(newDistance < node.distance) {
            node.distance = newDistance;
            List<Node> newPath = new ArrayList<>(currentNode.path);
            newPath.add(currentNode);
            node.path = newPath;
        }
        
    }
    
}