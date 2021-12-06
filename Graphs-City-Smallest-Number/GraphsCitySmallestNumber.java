class Solution {
    
    private class Edge {
        int destination;
        int weight;
        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
    
    private List<List<Edge>> adjacencyList = new ArrayList<>();
    private int distanceThreshold;
    
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        this.distanceThreshold = distanceThreshold;
        
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++) {
            adjacencyList.get(edges[i][0]).add(new Edge(edges[i][1], edges[i][2]));
            adjacencyList.get(edges[i][1]).add(new Edge(edges[i][0], edges[i][2]));
        }
        
        int minCity = 0;
        int minConnectedCities = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            Set<Integer> result = new HashSet<>();
            findMinConnectedCities(
                i,
                0, 
                new HashSet<>(),
                result
            );
            int potentialMinConnectedCities = result.size();
            // System.out.println("Potential Min Connected Cities: " + potentialMinConnectedCities);
            // System.out.println("");
            if(potentialMinConnectedCities <= minConnectedCities) {
                minCity = i;
                minConnectedCities = potentialMinConnectedCities;
            }
        }
        
        return minCity;
    }
    
    private void findMinConnectedCities(
        int currentCity,
        int currentDistance,
        Set<Integer> seen,
        Set<Integer> result) {
        
        // System.out.println("Current City " + currentCity);
        
        seen.add(currentCity);
        result.add(currentCity);
                
        for(Edge edge: adjacencyList.get(currentCity)) {
            
            if(currentDistance + edge.weight <= distanceThreshold && !seen.contains(edge.destination)) {
                
                findMinConnectedCities(
                    edge.destination,
                    currentDistance + edge.weight,
                    new HashSet<>(seen),
                    result
                );
                
            }
        }
        
    }
}