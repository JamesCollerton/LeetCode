class Solution {
       
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges == null || edges.length == 0) {
            return Collections.singletonList(0);
        }
        
        dp = new int[n][n];
        
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++) {
            int vertexOne = edges[i][0];
            int vertexTwo = edges[i][1];
            adjacencyList.get(vertexOne).add(vertexTwo);
            adjacencyList.get(vertexTwo).add(vertexOne);
        }
        
        Map<Integer, List<Integer>> heightToRootMap = new HashMap<>();
        int minHeight = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            int heightFromRoot = calculateHeight(adjacencyList, i, new HashSet<>());
            minHeight = Math.min(minHeight, heightFromRoot);
            
            if(heightToRootMap.containsKey(heightFromRoot)) {
                heightToRootMap.get(heightFromRoot).add(i);
            } else {
                List<Integer> newRootList = new ArrayList<>();
                newRootList.add(i);
                heightToRootMap.put(heightFromRoot, newRootList);
            }
        }
        
        return heightToRootMap.get(minHeight);
    }
    
    private int calculateHeight(List<List<Integer>> adjacencyList, int currentNode, Set<Integer> seen) {
        
        seen.add(currentNode);
        
        List<Integer> currentList = adjacencyList.get(currentNode);
        
        int height = 0;
        for(int i = 0; i < currentList.size(); i++) {
            if(!seen.contains(currentList.get(i))) {
                height = Math.max(height, calculateHeight(adjacencyList, currentList.get(i), new HashSet<>(seen)));
            }
        }
        
        return height + 1;
    }
}