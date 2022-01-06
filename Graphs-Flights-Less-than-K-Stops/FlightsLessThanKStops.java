class Solution {
        
    private class Node {
        int price;
        int city;
        int remainingStops;
        Node(int price, int city, int remainingStops) {
            this.price = price;
            this.city = city;
            this.remainingStops = remainingStops;
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    
        Map<Integer, Map<Integer, Integer>> adjacencyList = new HashMap<>();
        
        for(int[] flight: flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            
            if(!adjacencyList.containsKey(from)) {
                adjacencyList.put(from, new HashMap<>());
            }
            
            adjacencyList.get(from).put(to, price);
        }
        
        Queue<Node> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.price, b.price));
        
        queue.add(new Node(0, src, k + 1));
        int[] minHops = new int[n];
        
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node.city == dst) {
                return node.price;
            }
            if (node.remainingStops > 0) {
                if(!(minHops[node.city] != -1 && minHops[node.city] >= node.remainingStops)) {
                    minHops[node.city] = node.remainingStops;
                    Map<Integer, Integer> adj = adjacencyList.getOrDefault(node.city, new HashMap<>());
                    for (int a : adj.keySet()) {
                        queue.add(new Node(node.price + adj.get(a), a, node.remainingStops - 1));
                    }
                }
            }
        }
        
        return -1;
    }

    
}