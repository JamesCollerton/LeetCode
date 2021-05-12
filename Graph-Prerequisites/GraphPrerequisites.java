class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
                
        // Create a graph from the prerequisites representing edges
        Graph graph = new Graph(prerequisites, numCourses);
        
        // For each node in the graph do DFS. If we can get to a state
        // where we have seen all of the nodes then this represents a
        // successful ordering and we can return it
        for(int i = 0; i < numCourses; i++) {
            List<Integer> order = dfs(graph, i, new HashSet<Integer>(), numCourses);
            if(!order.isEmpty()) {
                return order.stream().mapToInt(v -> v).toArray();
            }
        }
        
        return new int[0];
    }
    
    // Perform DFS on the graph starting from vertex 'v'
    private List<Integer> dfs(Graph graph, int v, Set<Integer> seen, int target) {
        
        // mark the current node as discovered
        seen.add(v);
 
        List<Integer> resultList = new ArrayList<Integer>();
        
        // If we've got to the point where we've seen all of the 
        // courses then we can begin returning a successful list.
        if(seen.size() == target) {
            resultList.add(v);
            return resultList;
        }
        
        // do for every edge `v —> u`
        for (int u: graph.adjacencyList.get(v)) {
            
            // if `u` is not yet discovered
            if (!seen.contains(u)) {
                
                List<Integer> potentialResultList = dfs(graph, u, seen, target);
                
                if(!potentialResultList.isEmpty()) {
                    resultList.add(v);
                    resultList.addAll(potentialResultList);
                }
            }
        }
        
        return resultList;
    }
    
    private class Graph {
        
        // A list of lists to represent an adjacency list. Each
        // index in the list represents a source node, then the
        // list at that index represents all of the nodes that this
        // source node connects to
        List<List<Integer>> adjacencyList = null;

        Graph(int[][] edges, int N) {
            adjacencyList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                adjacencyList.add(new ArrayList<>());
            }

            // add edges to the undirected graph
            for (int[] edge: edges) {
                int src = edge[0];
                int dest = edge[1];

                // adjacencyList.get(src).add(dest);
                adjacencyList.get(dest).add(src);
            }
        }
    }
}