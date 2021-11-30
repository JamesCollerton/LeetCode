class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int totalNumberOfCities = isConnected.length;
        
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        for(int i = 0; i < totalNumberOfCities; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < isConnected.length; i++) {
            for(int j = 0; j < isConnected[i].length; j++) {
                if(isConnected[i][j] == 1) {
                    // We don't need to add both ways round
                    // as the matrix is symmetric.
                    if(i != j) {
                        adjacencyList.get(i).add(j);
                    }
                }
            }
        }
        
        Set<Integer> seenCities = new HashSet<>();
        int provinces = 0;
        
        for(int i = 0; i < adjacencyList.size(); i++) {
            
            if(!seenCities.contains(i)) {
                
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                
                while(!queue.isEmpty()) {
                    
                    Integer nextCity = queue.poll();
                    List<Integer> connectedCities = adjacencyList.get(nextCity);
                    
                    for(int j = 0; j < connectedCities.size(); j++) {
                        
                        int connectedCity = connectedCities.get(j);
                            
                        if(!seenCities.contains(connectedCity)) {
                            seenCities.add(connectedCity);
                            queue.add(connectedCity);
                        }
                    }
                }
                
                provinces++;
                
            }
            
        }
        
        return provinces;
    }
}