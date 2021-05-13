class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incLinkCounts = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList<>(numCourses);
        initialiseGraph(incLinkCounts, adjs, prerequisites);
        // Create a graph from the prerequisites representing edges
        // Graph graph = new Graph(prerequisites, numCourses);
        return solveByBFS(incLinkCounts, adjs);
        
    }
    
    private void initialiseGraph(int[] incLinkCounts, List<List<Integer>> adjs, int[][] prerequisites){
        // This is a list of the number of prerequisites for
        // each course
        int n = incLinkCounts.length;
        // Create a list of lists. Each index represents a course,
        // then each list represents its prerequisites.
        while (n-- > 0) {
            adjs.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            incLinkCounts[edge[0]]++;
            adjs.get(edge[1]).add(edge[0]);
        }
    }
    
    private int[] solveByBFS(int[] incLinkCounts, List<List<Integer>> adjs){
        // Create a new array for returning the order
        int[] order = new int[incLinkCounts.length];
        // This generates a queue of all of the courses with no prerequisites
        Queue<Integer> toVisit = new ArrayDeque<>();
        for (int i = 0; i < incLinkCounts.length; i++) {
            if (incLinkCounts[i] == 0) toVisit.offer(i);
        }
        int visited = 0;
        // Keep going through queue
        while (!toVisit.isEmpty()) {
            // Get the from 
            int from = toVisit.poll();
            // Add this to the visited list
            order[visited++] = from;
            // Go through all of the nodes
            // connected to this node and take away
            // one. If any of these now reaches zero
            // then it means that this node has had
            // all of its prerequisites visited and
            // we can add it to the queue.
            for (int to : adjs.get(from)) {
                incLinkCounts[to]--;
                if (incLinkCounts[to] == 0) {
                    toVisit.offer(to);
                }
            }
        }
        return visited == incLinkCounts.length ? order : new int[0]; 
    }
    
}