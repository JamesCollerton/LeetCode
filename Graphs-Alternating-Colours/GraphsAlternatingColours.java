class Solution {
    
    private int BLUE = 0;
    private int RED = 1;
    private int ANY = 2;
    
    private class Node {
        
        int node;
        int next;
        Set<Node> seen;
        
        Node(int node, int next, Set<Node> seen) {
            this.node = node;
            this.next = next;
            this.seen = seen;
        }
        
        @Override 
        public boolean equals(Object o) {
    
            Node that = (Node) o;
            
            // System.out.println("Here");
            
            return this.node == that.node && this.next == that.next;
            
        }
        
        @Override 
        public int hashCode() {
            return this.node + 99999999 + this.next;
        }
    }
    
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        int[] result = new int[n];
        List<List<Integer>> redAdjacencyList = new ArrayList<>();
        List<List<Integer>> blueAdjacencyList = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            result[i] = -1;
            redAdjacencyList.add(new LinkedList<>());
            blueAdjacencyList.add(new LinkedList<>());
        }
        
        for(int[] edge: redEdges) {
            redAdjacencyList.get(edge[0]).add(edge[1]);
        }
        
        for(int[] edge: blueEdges) {
            blueAdjacencyList.get(edge[0]).add(edge[1]);
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, ANY, new HashSet<>()));
        
        int distance = 0;
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            
            while(!queue.isEmpty() && size > 0) {
                
                Node node = queue.poll();
                
                if(!node.seen.contains(node)) {
                    
                    if(result[node.node] == -1) {
                        result[node.node] = distance;
                    }
                    
                    if(node.next == ANY || node.next == BLUE) {
                        for(int connectedNode: blueAdjacencyList.get(node.node)) {
                            Set<Node> seen = new HashSet<>(node.seen);
                            seen.add(node);
                            Node newNode = new Node(connectedNode, RED, seen);
                            if(!seen.contains(newNode)) {
                                queue.offer(newNode);
                            }
                        }
                    }
                    
                    if(node.next == ANY || node.next == RED) {
                        for(int connectedNode: redAdjacencyList.get(node.node)) {
                            Set<Node> seen = new HashSet<>(node.seen);
                            seen.add(node);
                            Node newNode = new Node(connectedNode, BLUE, seen);
                            if(!seen.contains(newNode)) {
                                queue.offer(newNode);
                            }
                        }
                    }
                    
                }
                
                size--;
            }
            
            distance++;
        }
        
        return result;
    }
}